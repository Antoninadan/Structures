package ua.i.mail100.array;

public class MyArrayList {
    private int[] mas;
    private int size;
    private int index;

    public MyArrayList(int size) {
        this.index = 0;
        this.size = size;
        this.mas = new int[size];
    }

    public int[] getMas() {
        return mas;
    }

    public void setMas(int[] mas) {
        this.mas = mas;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("size=");
        result.append(size);
        result.append(": [");

        for (int i = 0; i < size; i++) {
            result.append(mas[i]);
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
            result.append(mas[i]);
            if (i > 0) result.append(", ");
            else result.append("]");
        }
        return result.toString();
    }


    public void add(int value) {
        if (index == size) {
            throw new RuntimeException("array is full");
        }
        mas[index] = value;
        index++;
    }

    public void add(MyArrayList added) {
        if (size <= (index + added.index - 2)) {
            throw new RuntimeException("dont have enaught size");
        }
        int start = index;
        for (int i = start; i < (start + added.index); i++) {
            mas[i] = added.mas[i - start];
            index++;
        }
    }

    public void delete(int indexToDelete) {
        if (indexToDelete + 1 > size) {
            throw new RuntimeException("wrong index");
        }

        if (size == 1) {
            throw new RuntimeException("dont delete the last element");
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

        mas = result.mas;
        size--;
        index = result.index;
    }

    public void change(int indexToChange, int value) {
        if (indexToChange > index) {
            throw new RuntimeException("wrong index");
        }

        mas[indexToChange] = value;
    }

    public void increaseOnSize(int additionalSize) {
        MyArrayList result = new MyArrayList(size + additionalSize);
        result.add(this);
        mas = result.mas;
        size += additionalSize;
    }

    public void decreaseToSize(int newSize) {
        if (index > newSize) {
            throw new RuntimeException("current array content more then required size");
        }

        MyArrayList result = new MyArrayList(newSize);
        result.add(this);
        mas = result.mas;
        size = newSize;
    }

    public static MyArrayList getArrayCopiedFrom(MyArrayList array, int indexFrom, int indexTo) {
        if ((indexFrom > indexTo) || (array.size <= indexTo)) {
            throw new RuntimeException("wrong indexes");
        }

        int resultSize = indexTo - indexFrom + 1;
        MyArrayList result = new MyArrayList(resultSize);
        for (int i = indexFrom; i <= indexTo; i++) {
            result.add(array.mas[i]);
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

        mas = result.mas;
        size = newSize;
        index = result.index;
    }

    public void sort() {
        MyArrayList result = getArrayCopiedFrom(this, 0, index);
        SortService.buble(result.mas);
        result.increaseOnSize(size - index);

        mas = result.mas;
    }

    public int seacrh(int criteria) {
        MyArrayList array = getArrayCopiedFrom(this, 0, index);
        return SearchService.linear(array.mas, criteria);
    }

    public void shuffle() {
        MyArrayList result = getArrayCopiedFrom(this, 0, index);
        ShuffleService.shuffle(result.mas);
        result.increaseOnSize(size - index);

        mas = result.mas;
    }

    public void deleteDuplicates() {
        for (int i = 0; i <= index; i++) {
            int current = mas[i];
            for (int j = i + 1; j <= index; j++) {
                if (current == mas[j])
                    delete(j);
            }
        }
    }
}
