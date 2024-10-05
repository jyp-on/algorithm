class Solution {
    public List<String> letterCombinations(String str) {
        if(str.isEmpty())return new ArrayList<>();
        String[] key = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> set = new ArrayList<>();
        GG(str,"",key,set);
        return set;
    }

    public void GG(String str, String ans, String[] key, ArrayList<String> set) {
        if (str.length() == 0) {
            set.add(ans);
            return;
        }

        String k = key[str.charAt(0)-48];
        for(int i=0;i<k.length();i++){
            GG(str.substring(1),ans+k.charAt(i),key,set);
        }
    }
}