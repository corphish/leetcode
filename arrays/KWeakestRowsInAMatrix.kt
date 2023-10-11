// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix
class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val rows = mutableListOf<Row>()
        for ((index, row) in mat.withIndex()) {
            var count = 0
            for (x in row) {
                count += x
            }
            
            rows += Row(count, index)
        }
        
        return rows.sortedBy { it.count }.map { it.index }.take(k).toIntArray()
    }
    
    data class Row(
        val count: Int,
        val index: Int
    )
}