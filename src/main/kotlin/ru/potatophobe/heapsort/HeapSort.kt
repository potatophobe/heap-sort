package ru.potatophobe.heapsort

fun selectionSort(array: IntArray) {
    for (j in array.lastIndex downTo 1) {
        var indexOfMaximum = 0
        for (i in 0..j) {
            if (array[i] > array[indexOfMaximum]) {
                indexOfMaximum = i
            }
        }
        array.swap(indexOfMaximum, j)
    }
}

fun heapSort(array: IntArray) {
    for (i in array.size / 2 - 1 downTo 0) {
        array.heapify(i, array.size)
    }

    for (j in array.lastIndex downTo 1) {
        array.swap(0, j)
        array.heapify(0, j)
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    val temp = get(i)
    set(i, get(j))
    set(j, temp)
}

private fun IntArray.heapify(i: Int, size: Int) {
    val leftChildIndex = (i * 2) + 1
    val rightChildIndex = (i * 2) + 2
    var indexOfMaximum = i

    if (leftChildIndex < size && get(leftChildIndex) > get(indexOfMaximum)) {
        indexOfMaximum = leftChildIndex
    }
    if (rightChildIndex < size && get(rightChildIndex) > get(indexOfMaximum)) {
        indexOfMaximum = rightChildIndex
    }

    if (indexOfMaximum == i) return

    swap(indexOfMaximum, i)
    heapify(indexOfMaximum, size)
}
