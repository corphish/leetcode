// https://leetcode.com/problems/implement-router/
class Router(private val memoryLimit: Int) {
    private val _destinationMap = mutableMapOf<Int, MutableList<Int>>()
    private val _packetList = mutableListOf<IntArray>()
    private val _set = hashSetOf<String>()
    private var _fifoIndex = 0

    fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
        var willExceedLimit = false

        if (_packetList.size - _fifoIndex == memoryLimit) {
            willExceedLimit = true
        }
        
        val packet = intArrayOf(source, destination, timestamp)

        if (!_set.add(packet.contentToString())) {
            return false
        }

        _packetList.add(packet)

        val list = _destinationMap[destination] ?: mutableListOf()
        list += timestamp
        _destinationMap[destination] = list

        if (willExceedLimit) {
            forwardPacket()
        }

        return true
    }

    fun forwardPacket(): IntArray {
        if (_fifoIndex == _packetList.size) {
            return intArrayOf()
        }

        val res = _packetList[_fifoIndex]
        _fifoIndex += 1
        _set.remove(res.contentToString())

        val list = _destinationMap[res[1]] ?: mutableListOf()
        val index = list.binarySearch(res[2])
        list.removeAt(index)
        _destinationMap[res[1]] = list

        return res    
    }

    fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
        val list = _destinationMap[destination]

        if (list == null || list.size == 0) {
            return 0
        }

        var start = searchLow(list, startTime)
        var end = searchHigh(list, endTime)

        if (start < 0) {
            start = -start - 1
        }

        if (end < 0) {
            end = -end - 1
            end = end - 1
        }

        return end - start + 1
    }

    private fun searchLow(
        list: MutableList<Int>,
        value: Int
    ): Int {
        var low = 0
        var high = list.size - 1

        while (low <= high) {
            val mid = (low + high)/2

            if (list[mid] == value) {
                if (mid == 0) {
                    return mid
                } else {
                    if (list[mid - 1] != value) {
                        return mid
                    } else {
                        high = mid - 1
                    }
                }
            } else if (list[mid] > value) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return -low - 1
    }

    private fun searchHigh(
        list: MutableList<Int>,
        value: Int
    ): Int {
        var low = 0
        var high = list.size - 1

        while (low <= high) {
            val mid = (low + high)/2

            if (list[mid] == value) {
                if (mid == list.size - 1) {
                    return mid
                } else {
                    if (list[mid + 1] != value) {
                        return mid
                    } else {
                        low = mid + 1
                    }
                }
            } else if (list[mid] > value) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return -low - 1
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * var obj = Router(memoryLimit)
 * var param_1 = obj.addPacket(source,destination,timestamp)
 * var param_2 = obj.forwardPacket()
 * var param_3 = obj.getCount(destination,startTime,endTime)
 */