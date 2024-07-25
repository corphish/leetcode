// Kotlin
// https://leetcode.com/problems/sort-the-people/
class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val list = mutableListOf<People>()
        for ((i, v) in names.withIndex()) {
            list += People(names[i], heights[i])
        }
        
        return list.sortedBy { -it.height }.map { it.name }.toTypedArray()
    }
    
    data class People(val name: String, val height: Int)
}