public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"apple","app"};
        LongestCommonPrefix lPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix(strs));
        System.out.println(lPrefix.longestCommonPrefix2String(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int j = 1;
        for(int i = 0; i < 200; i++){
            for(; j < strs.length; j++){
                if(i >= strs[j].length() || i >= strs[j - 1].length()){
                    return sb.toString();
                }
                if(strs[j - 1].equals("")){
                    return "";
                }
                if(strs[j].charAt(i) == strs[j - 1].charAt(i)){
                    continue;
                }else{
                    return sb.toString();
                }
            }
            sb.append(strs[j - 1].charAt(i));
            j = 1;
        }
        return sb.toString();
    }
    public String longestCommonPrefix2String(String[] strs) {
        // 首先假设数组中第一个字符串就是最长公共前缀
        String prefix = strs[0];
        // 从数组的第二个字符串开始遍历
        for (int i = 1; i < strs.length; i++) {
            // 当当前字符串不以当前前缀开头时
            while (!strs[i].startsWith(prefix)) {
                // 将前缀的长度减 1，即去掉前缀的最后一个字符
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        // 返回最终得到的最长公共前缀
        return prefix;
    }
}
