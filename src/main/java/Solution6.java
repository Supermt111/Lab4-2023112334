import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution6 {
    // 存储每个用户的收藏公司（转为Set，方便判断子集）
    Set<String>[] s = new Set[105];

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // 修复：初始化s数组从i=0开始（原代码从i=1开始，s[0]为null）
        for (int i = 0; i < 105; ++i) {
            s[i] = new HashSet<String>();
        }
        // 修复：n应为集合的完整大小（原代码多减了1）
        int n = favoriteCompanies.size();
        List<Integer> ans = new ArrayList<Integer>();

        // 第一步：将所有用户的收藏清单转为Set存入s数组（优化查询效率）
        for (int i = 0; i < n; ++i) {
            for (String com : favoriteCompanies.get(i)) {
                s[i].add(com);
            }
        }

        // 第二步：遍历每个用户i，判断是否是其他用户j的子集
        for (int i = 0; i < n; ++i) {
            boolean isSubsetOfAny = false; // 标记i是否是任何j（j≠i）的子集
            for (int j = 0; j < n; ++j) {
                if (i == j) continue; // 跳过自己
                // 若i是j的子集，标记后直接break（无需检查其他j）
                if (check(i, j)) {
                    isSubsetOfAny = true;
                    break;
                }
            }
            // 修复：逻辑反转——不是任何j的子集，才加入结果
            if (!isSubsetOfAny) {
                ans.add(i);
            }
        }

        return ans;
    }

    // 修复：将check方法移出peopleIndexes（Java不允许方法嵌套）
    // 功能：判断用户x的收藏清单是否是用户y的子集
    private boolean check(int x, int y) {
        // 遍历x的所有公司，若有一个不在y的集合中，则不是子集
        for (String com : s[x]) {
            if (!s[y].contains(com)) {
                return false;
            }
        }
        return true;
    }
}