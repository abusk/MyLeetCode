class Solution {
    public String[] splitMessage(String message, int limit) {
        
        int low = 1, high = message.length();
        int result = Integer.MAX_VALUE;

        while( low<=high ) {
            int mid = low + (high-low)/2;

            int value = checkValidity(message, limit, mid); 
            // System.out.println(mid+" "+value);
            if(value == 0) {
                result = Math.min(result, mid);
                high = mid - 1;
                low = 1;
            }
            else if( value == -1 ) high = mid - 1;
            else low = mid + 1;
        }
        // System.out.println(result);

        if( result == Integer.MAX_VALUE) return new String[0];
        else return getFormattedStrings(message, limit, result);
    }

    private int checkValidity(String message, int limit, int k) {

        int idx = 0;
        for(int i=1; i<=k; i++) {

            if( idx >= message.length() ) return -1;
            String format = "<"+i+"/"+k+">";
            int left = limit - format.length();

            if( left <= 0 ) return -1;

            idx += left;

        }

        if( idx < message.length()) return 1;

        return 0;
    }

    private String[] getFormattedStrings(String message, int limit, int k) {
        String [] result = new String[k];

        int idx = 0;
        for(int i=1; i<=k; i++) {
            String format = "<"+i+"/"+k+">";
            int diff = limit-format.length();
            
            if( idx+diff > message.length() ) result[i-1] = message.substring(idx)+format;
            else result[i-1] = message.substring(idx, idx+diff)+format;

            idx += diff;
        }
        return result;   
    }
}