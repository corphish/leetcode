// https://leetcode.com/problems/rearrange-words-in-a-sentence
class Solution {
    fun arrangeWords(text: String): String {
        return text
            .split(" ")
            .sortedBy { it.length }
            .map { it.toLowerCase() }
            .joinToString(" ")
            .capitalize()
    }
}