package com.sword_to_offer;

// 5 替换空格
// 请实现一个函数，将一个字符串中的空格替换成 “%20”。
// 例如，当字符串为 We Are Happy. 则经过替换之后的字符串为 We%20Are%20Happy。
public class ReplaceBlank {
    public String replaceSpace(StringBuffer str) {
        // 计算字符串中，空格的总数
        int sum_blank = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ' ')
                sum_blank++;

        int index_old_last = str.length() - 1;  // 原字符串中最后一个字符的下标
        int new_length = str.length() + sum_blank*2;    // 新的字符串的长度
        int index_new_last = new_length - 1;    // 新字符串中最后一个字符的下标
        str.setLength(new_length);  // 重新设置字符串的长度
        while (index_new_last > 0){
            if (str.charAt(index_old_last) == ' '){ // 若原字符串中的字符为 ' '
                str.setCharAt(index_new_last--, '0');
                str.setCharAt(index_new_last--, '2');
                str.setCharAt(index_new_last--, '%');
            }else { // 若原字符串中的字符不为 ' '
                str.setCharAt(index_new_last--, str.charAt(index_old_last));
            }
            index_old_last--;
        }
        return str.toString();
    }


//    public String replaceSpace(StringBuffer str) {
//        for (int i = 0; i < str.length(); i++)
//            if (str.charAt(i) == ' ')
//                str.replace(i, i + 1, "%20");
//        return str.toString();
//    }


    // 时间复杂度 O(n)，空间复杂度 O(n)
//    public String replaceSpace(StringBuffer str) {
//        StringBuilder result_str = new StringBuilder();
//        char[] char_arr = {'%', '2', '0'};
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ' ')
//                result_str.append(char_arr);
//            else
//                result_str.append(str.charAt(i));
//        }
//        return result_str.toString();
//    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        String result_str = new ReplaceBlank().replaceSpace(str);
        System.out.println(result_str);
    }

}
