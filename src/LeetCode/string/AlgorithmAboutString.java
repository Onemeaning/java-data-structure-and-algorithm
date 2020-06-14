package LeetCode.string;

public class AlgorithmAboutString {

    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }


    /**
     * 125 : 验证回文字符串；
     *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {

//        s = s.toLowerCase();
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')){
//                builder.append(ch);
//            }
//        }
//        s = builder.toString();

        char[] charArray = s.toCharArray();

        int left = 0;
        int right = s.length()-1;

        while ( left < right){

            while (!Character.isLetterOrDigit(charArray[left]) && left < right){

                left++;
            }

            while (!Character.isLetterOrDigit(charArray[right]) && left < right){

                right--;
            }

            if (Character.toLowerCase(charArray[left]) != Character.toLowerCase(charArray[right]))
                return false;

            left++;
            right--;

        }
        return true;
    }

}
