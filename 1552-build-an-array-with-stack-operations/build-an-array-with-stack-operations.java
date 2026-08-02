class Solution {
    public List<String> buildArray(int[] target, int n) {
        int p =0;
        List<String> li = new ArrayList<>();
        for(int i=1; i<=n; i++){
            li.add("Push");
            if(i != target[p]){
                li.add("Pop");
            }else{
                p++;
            }
            if(p >= target.length){
                break;
            }
        }
        return li;
    }
}