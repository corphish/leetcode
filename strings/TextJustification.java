// https://leetcode.com/problems/text-justification/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> buffer = new ArrayList<>();
        int lenSum = 0;
        for (String word: words) {
            if (word.length() + lenSum > maxWidth) {
                result.add(justify(buffer, lenSum, maxWidth));
                buffer.clear();
                buffer.add(word);
                lenSum = word.length() + 1;
            } else {
                buffer.add(word);
                lenSum += word.length() + 1;
            }
        }

        result.add(justifyLastLine(buffer, maxWidth));
        return result;
    }

    String justifyLastLine(List<String> words, int width) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String word: words) {
            sb.append(word);
            count += word.length();
            if (count < width) {
                sb.append(" ");
                count += 1;
            }
        }

        sb.append(spaces(width - count));
        return sb.toString();
    }

    String justify(List<String> words, int lenSum, int width) {
        int totalSpaces = width - (lenSum - words.size());
        int spaceBlocks = Math.max(1, words.size() - 1);
        int[] spaceDist = getSpaceDistribution(totalSpaces, spaceBlocks);
        int k = 0;
        StringBuffer sb = new StringBuffer();

        for (String word: words) {
            sb.append(word);
            if (k < spaceDist.length)
                sb.append(spaces(spaceDist[k++]));
        }

        return sb.toString();
    }

    String spaces(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }

    int[] getSpaceDistribution(int spaceCount, int blockCount) {
        int[] dist = new int[blockCount];
        int n = blockCount;
        for (int i = 0; i < n; i++) {
            int block = (int) Math.ceil((spaceCount * 1.0)/blockCount);
            spaceCount -= block;
            blockCount -= 1;
            dist[i] = block;
        }

        return dist;
    }
}