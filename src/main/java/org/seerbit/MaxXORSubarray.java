package org.seerbit;

import org.seerbit.model.Node;

public class MaxXORSubarray {

    Node root;

    public MaxXORSubarray() {
        this.root = new Node();
    }

    private void put(int number) {
        Node node = root;

        for(int i = 31; i >= 0; i--) {
            int bit = (number >> i) & 1;
            if(node.getNode()[bit] == null) {
                node.getNode()[bit] = new Node();
            }
            node = node.getNode()[bit];
        }
        node.setEnd(true);
    }

    private int findMaxXOR(int number) {
        Node node = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (number >> i) & 1;
            if (node.getNode()[1-bit] != null) {
                xor |= (1 << i);
                node = node.getNode()[1-bit];
            } else {
                node = node.getNode()[bit];
            }
        }

        return xor;
    }

    public static int getMaxXOR(int[] numbers) {

        MaxXORSubarray maxXORSubarray = new MaxXORSubarray();
        int maxXOR = 0;
        int prefixXOR = 0;
        maxXORSubarray.put(0);

        for(int number : numbers) {
            prefixXOR ^= number;
            maxXORSubarray.put(prefixXOR);
            maxXOR = Math.max(maxXOR, maxXORSubarray.findMaxXOR(prefixXOR));
        }

        return maxXOR;
    }
}
