// 

class Solution {
    boolean used[];
    int val[];
    boolean not[];
    public boolean isSolvable(String[] words, String result) {
        val=new int[26];
        Arrays.fill(val,-1);
        used=new boolean[10];
        not = new boolean[26];
        for(String w:words){
            if(w.length()>1)    not[w.charAt(0)-'A']=true;
        }
        if(result.length()>1)   not[result.charAt(0)-'A']=true;
        return dfs(0,0,0,0,words,result);
    }
    boolean dfs(int ans,int x,int wi,int wii,String w[],String res){
        
        if(wii==w[wi].length()){
            wi++;
            wii=0;
            ans+=x;
            x=0;
        }
        // System.out.println("word: "+wi+" index: "+wii);
        if(wi==w.length){
            boolean f = find(0,res,0,ans);
            ans-=x;
            return f;
        }
        
        if(val[w[wi].charAt(wii)-'A']!=-1){
            return dfs(ans, x*10+val[w[wi].charAt(wii)-'A'], wi, wii+1, w, res);
        }
          
        for(int i=0;i<10;i++){
            if( i==0 && not[w[wi].charAt(wii)-'A'] )  continue;
            if(!used[i]){
                val[ w[wi].charAt(wii) -'A'] = i;
                used[i]=true;
                if(dfs(ans, x*10+i, wi, wii+1, w, res))  return true;
                used[i]=false;
                val[ w[wi].charAt(wii) -'A'] = -1;
            }
        }
           
        return false;
    }
    boolean find(int cur,String s,int id,int x){
        if(id==s.length()){
            if(x==cur)  return true;
            return false;
        }
        
        if(val[s.charAt(id)-'A']!=-1){
            return find(cur*10+val[s.charAt(id)-'A'], s, id+1, x);
        }
        
        for(int i=0;i<10;i++){
            if( i==0 && not[s.charAt(id)-'A'] )   continue;
            if(!used[i]){
                val[ s.charAt(id) -'A'] = i;
                used[i]=true;
                if(find(cur*10+i,s,id+1,x)) return true;
                used[i]=false;
                val[ s.charAt(id) -'A'] = -1;
            }
        }
        
        return false;
    }
}