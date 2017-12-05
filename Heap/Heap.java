public class Heap {

    int max;
    int size;
    int[] container; //array

    Heap(int max) {

        this.max = max;
        this.size = size;
        this.container = new int[max];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int leftChild(int i) {
        return (2 * i + 1);
    }

    int rightChild(int i) {
        return (2 * i + 2);
    }

    public void add(int value) {
        if (size == max) {
            System.out.println("Already full!");
        } else {
            container[size - 1] = value;
            size++;
            bU(size - 1);
        }
    }

    public int remove() {
        if (size == 0) {
            return -1;
        }

        int i = container[0];

        if (size > 1) {
            container[0] = container[size];
            size--;

            tD(0);
        }
        return i;
    }

    public void preorder(int index) {
        if (index <= size - 1) {
            System.out.println(container[index]);
            preorder(leftChild(index));
            preorder(rightChild(index));
        }
    }

    public void inorder(int index) {
        if (index <= size - 1) {
            inorder(leftChild(index));
            System.out.println(container[index]);
            inorder(rightChild(index));
        }
    }

    public void postorder(int index) {
        postorder(rightChild(index));
        postorder(leftChild(index));
        System.out.println(container[index]);

    }

    void bU(int index) { //for adding
        int temp;
        if (parent(index) > 0 && container[index] <= container[parent(index)]) {
            if (container[index] < container[parent(index)]) {
                temp = container[index];
                container[index] = container[parent(index)];
                container[parent(index)] = temp;
                bU(parent(index));
            }
        }
    }

    void tD(int index) { //for removing
        int temp;

        do {
            if (container[leftChild(index)] < container[rightChild(index)]) {
                temp = container[index];
                container[index] = container[leftChild(index)];
                container[leftChild(index)] = temp;
                index = leftChild(index);
            } else {
                temp = container[index];
                container[index] = container[rightChild(index)];
                container[rightChild(index)] = temp;
                index = rightChild(index);
            }
        } while ((leftChild(index) == size) || (rightChild(index) == size) && (container[index] > container[leftChild(index)])
                && (container[index] > container[rightChild(index)]));
    }
}
