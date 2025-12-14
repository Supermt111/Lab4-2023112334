import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class L20231234_6_Test {
    private final Solution6 solution6 = new Solution6();

    // 打印分隔线，区分不同测试用例
    private static final String SEPARATOR = "==============================================";

    @Test
    public void testExample1() {
        // 1. 构建输入数据（所有ArrayList显式指定泛型类型，兼容JDK 8）
        List<List<String>> input = new ArrayList<List<String>>();
        List<String> user0 = new ArrayList<String>() {{
            add("leetcode");
            add("google");
            add("facebook");
        }};
        List<String> user1 = new ArrayList<String>() {{
            add("google");
            add("microsoft");
        }};
        List<String> user2 = new ArrayList<String>() {{
            add("google");
            add("facebook");
        }};
        List<String> user3 = new ArrayList<String>() {{
            add("google");
        }};
        List<String> user4 = new ArrayList<String>() {{
            add("amazon");
        }};
        input.add(user0);
        input.add(user1);
        input.add(user2);
        input.add(user3);
        input.add(user4);

        // 🔥 核心改动：故意写错预期结果（正确应为[0,1,4]，改为[0,2,4]）
        List<Integer> expected = new ArrayList<Integer>() {{
            add(0);
            add(2);  // 错误值：原正确是1，改为2
            add(4);
        }};

        // 3. 执行方法获取实际结果
        List<Integer> actual = solution6.peopleIndexes(input);

        // 4. 打印详细信息
        System.out.println(SEPARATOR);
        System.out.println("测试用例：testExample1（多用户+部分子集场景）");
        System.out.println("输入数据（用户索引→收藏公司）：");
        for (int i = 0; i < input.size(); i++) {
            System.out.printf("用户%d：%s%n", i, input.get(i));
        }
        System.out.println("预期结果（不被任何用户包含的索引）：" + expected);
        System.out.println("实际结果（不被任何用户包含的索引）：" + actual);
        System.out.println(SEPARATOR);

        // 5. 断言验证（必然失败）
        assertEquals("testExample1 测试失败！", expected, actual);
    }

    @Test
    public void testSingleUser() {
        // 1. 构建输入数据（显式指定泛型类型）
        List<List<String>> input = new ArrayList<List<String>>();
        List<String> user0 = new ArrayList<String>() {{
            add("github");
        }};
        input.add(user0);

        // 🔥 核心改动：故意写错预期结果（正确应为[0]，改为[1]）
        List<Integer> expected = new ArrayList<Integer>() {{
            add(1);  // 错误值：原正确是0，改为1
        }};

        // 3. 执行方法获取实际结果
        List<Integer> actual = solution6.peopleIndexes(input);

        // 4. 打印详细信息
        System.out.println(SEPARATOR);
        System.out.println("测试用例：testSingleUser（单用户边界场景）");
        System.out.println("输入数据（用户索引→收藏公司）：");
        for (int i = 0; i < input.size(); i++) {
            System.out.printf("用户%d：%s%n", i, input.get(i));
        }
        System.out.println("预期结果（不被任何用户包含的索引）：" + expected);
        System.out.println("实际结果（不被任何用户包含的索引）：" + actual);
        System.out.println(SEPARATOR);

        // 5. 断言验证（必然失败）
        assertEquals("testSingleUser 测试失败！", expected, actual);
    }

    @Test
    public void testAllSubset() {
        // 输入：显式指定所有泛型类型
        List<List<String>> input = new ArrayList<List<String>>();
        input.add(new ArrayList<String>() {{
            add("a");
        }});          // 用户0
        input.add(new ArrayList<String>() {{
            add("a");
            add("b");
        }}); // 用户1
        input.add(new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }}); // 用户2

        // 🔥 核心改动：故意写错预期结果（正确应为[2]，改为[0]）
        List<Integer> expected = new ArrayList<Integer>() {{
            add(0);  // 错误值：原正确是2，改为0
        }};
        List<Integer> actual = solution6.peopleIndexes(input);

        // 打印信息
        System.out.println(SEPARATOR);
        System.out.println("测试用例：testAllSubset（全子集链式场景）");
        System.out.println("输入数据（用户索引→收藏公司）：");
        for (int i = 0; i < input.size(); i++) {
            System.out.printf("用户%d：%s%n", i, input.get(i));
        }
        System.out.println("预期结果（不被任何用户包含的索引）：" + expected);
        System.out.println("实际结果（不被任何用户包含的索引）：" + actual);
        System.out.println(SEPARATOR);

        assertEquals("testAllSubset 测试失败！", expected, actual);
    }
}