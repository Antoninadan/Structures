package ua.i.mail100.array;

public class MyArrayList {
    private static final String EXCEPTION_WRONG_INDEX = "Wrong index";
    private static final String EXCEPTION_DELETE_LAST_ELEMENT = "Forbidden delete the last element";
    private static final String EXCEPTION_DECREASE_TO_LESS_SIZE = "Array has more then required size";


    private int[] array;
    private int size;
    private int index;

    public MyArrayList(int size) {
        this.index = 0;
        this.size = size;
        this.array = new int[size];
    }

    public int[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("size=");
        result.append(size);
        result.append(": [");

        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < (size - 1)) result.append(", ");
            else result.append("]");
        }
        return result.toString();
    }

    public String toStringReverse() {
        StringBuffer result = new StringBuffer();
        result.append("Reverse, size=");
        result.append(size);
        result.append(": [");

        for (int i = size - 1; i >= 0; i--) {
            result.append(array[i]);
            if (i > 0) result.append(", ");
            else result.append("]");
        }
        return result.toString();
    }

    public void add(int value) {
        if (index == size) {
            this.increaseOnSize(size);
        }
        array[index] = value;
        index++;
    }

    public void add(MyArrayList added) {
        if (size <= (index + added.index )) {
            this.increaseOnSize(size + added.index);
        }

        int startIndex = index;

        for (int i = startIndex; i < startIndex + added.index; i++) {
            array[i] = added.array[i - startIndex];
            index++;
        }
    }

    public void deleteByIndex(int indexToDelete) {
        if (indexToDelete + 1 > size) {
            throw new RuntimeException(EXCEPTION_WRONG_INDEX);
        }

        if (size == 1) {
            throw new RuntimeException(EXCEPTION_DELETE_LAST_ELEMENT);
        }

        MyArrayList result;

        if (indexToDelete == 0) {
            result = getArrayCopiedFrom(this, 1, size - 1);
        } else {
            result = getArrayCopiedFrom(this, 0, indexToDelete - 1);
            if ((indexToDelete + 1) < size) {
                MyArrayList tail = getArrayCopiedFrom(this, indexToDelete + 1, size - 1);
                result.concatenateWith(tail);
            }
        }

        array = result.array;
        size--;
        index = result.index;
    }

    public void change(int indexToChange, int value) {
        if (indexToChange > index) {
            throw new RuntimeException(EXCEPTION_WRONG_INDEX);
        }

        array[indexToChange] = value;
    }

    public void increaseOnSize(int additionalSize) {
        MyArrayList result = new MyArrayList(size + additionalSize);
        result.add(this);
        array = result.array;
        size += additionalSize;
    }

    public void decreaseToSize(int newSize) {
        if (index > newSize) {
            throw new RuntimeException(EXCEPTION_DECREASE_TO_LESS_SIZE);
        }

        MyArrayList result = new MyArrayList(newSize);
        result.add(this);
        array = result.array;
        size = newSize;
    }

    public static MyArrayList getArrayCopiedFrom(MyArrayList array, int indexFrom, int indexTo) {
        if (indexFrom > indexTo || array.size <= indexTo) {
            throw new RuntimeException(EXCEPTION_WRONG_INDEX);
        }

        int resultSize = indexTo - indexFrom + 1;
        MyArrayList result = new MyArrayList(resultSize);
        for (int i = indexFrom; i <= indexTo; i++) {
            result.add(array.array[i]);
        }

        if (array.index > indexTo) {
            result.index = resultSize;
        } else if (array.index >= indexFrom) {
            result.index = array.index - indexFrom;
        } else {
            result.index = 0;
        }

        return result;
    }

    public void concatenateWith(MyArrayList concatenated) {
        int newSize = size + concatenated.size;
        MyArrayList result = new MyArrayList(newSize);

        result.add(this);
        result.add(concatenated);

        array = result.array;
        size = newSize;
        index = result.index;
    }

    public void sort() {
        MyArrayList result = getArrayCopiedFrom(this, 0, index);
        SortService.buble(result.array);
        result.increaseOnSize(size - index);

        array = result.array;
    }

    public int seacrh(int criteria) {
        MyArrayList array = getArrayCopiedFrom(this, 0, index);
        return SearchService.linear(array.array, criteria);
    }

    public void shuffle() {
        MyArrayList result = getArrayCopiedFrom(this, 0, index);
        ShuffleService.shuffle(result.array);
        result.increaseOnSize(size - index);

        array = result.array;
    }

    public void deleteDuplicates() {
        for (int i = 0; i <= index; i++) {
            int current = array[i];
            for (int j = i + 1; j <= index; j++) {
                if (current == array[j])
                    deleteByIndex(j);
            }
        }
    }
}
