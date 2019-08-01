
public class Main {

    public static void main(String[] args) {

        //System.out.println( compress( new char[]{'a','a','b','b','c','c','c'}) );
        //System.out.println( compress( new char[]{'a','a','a','b','b','a','a'}));
        System.out.println( compress( new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'} ));
        //System.out.println( compress( new char[]{'a','a','a','b','b','b','c','c','c'}  ));
        //System.out.println( compress( new char[] {'a','a','a','b','b','b','c','c','c'} ));
        //System.out.println( compress( new char[] {'a','a','a','a','a','b'} ));
        //System.out.println( compress( new char[] {'o','o','o','o','o','o','o','o','o','o'} ));
        //System.out.println( compress( new char[] {'a','a','a','b','b','a','a'}));

    }

    public static int compress(char[] chars) {

        // anchor is what you write from to write index, it would contain next-to-be-written characters
        // write has your last index that u have to write to
        // read is your explorer and finds out if we need to compress

        int anchor=0, write=0;

        for (int read =0 ; read < chars.length ; read++) {

            // we need to compress if if statement is true, read stops at last
            // char before getting new char which means read+1 will get the new char
            // later we will put read+1 into anchor
            if(read+1 == chars.length || chars[read+1]!=chars[read]){

                //write the character first from anchor to where u r supposed to write it
                chars[write++] = chars[anchor];

                //if there is a compression number to be written, write to char
                if(read>anchor){

                    for( char c : (""+(read-anchor+1)).toCharArray() ){
                        chars[write++] = c;
                    }

                }

                // update anchor to one after read when compression of previous char is done
                // to get the next character to be weritten to write later
                anchor = read+1;

            }


        }


        return write;

    }

}
