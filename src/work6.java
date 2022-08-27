    import java.util.*;
    import java.io.*;
// 在專案裡有幾個.txt檔 ,這些檔內容有 詩 文章,
// 而這專案的目的就是將檔案裡的特定字詞改成自己想要的文字
// 改成自己想要的文字後，原本檔案不變，新建一個檔去儲存(檔名自行設定)
    public class work6 {
        public static void main(String[] args) throws FileNotFoundException {
            Welcome();
            char ans = ' ';
            //依照輸入不同有不同的回應
            while (ans != 'q') {// 直到輸入q 才會結束
                System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
                ans = input().toLowerCase().charAt(0);//看輸入 判要哪個選項
                if ('c' == ans) {
                    String lookForFile =  exist();
                    //準備好待會新的檔案的名字//讀現有的檔案//顯示要改的字 頭是 a 要是an // 讀取輸入的字 將有<>的字替換掉//並將替換掉的回傳到新的檔案 改成的字要變成藍色的//一行一行回傳
                    System.out.print("Output file name: ");
                    String outputMyNew = input();
                    PrintStream output = new PrintStream(new File(outputMyNew));
                    System.out.println();
                    Scanner compare = new Scanner(new File(lookForFile));//當下的檔案
                    //讀每一行 找出有<>
                    while (compare.hasNextLine()) {
                        output.println(newSentence(compare.nextLine()));
                    }
                    System.out.println("Your mad-lib has been created!");
                } else if ('v' == ans) {
                    String lookForFile = exist();
                    Scanner compare = new Scanner(new File(lookForFile));
                    while (compare.hasNextLine()) {
                        System.out.println(compare.nextLine());
                    }
                    System.out.println();
                }
            }
        }
            public static String exist() {
                Scanner input = new Scanner(System.in);
                System.out.print("Input file name: ");
                String lookForFile = input.nextLine(); // input是讀輸入的字
                while (!(new File(lookForFile).exists())) {
                    System.out.print("File not found. Try again: ");
                    lookForFile = input.nextLine();
                }
                return lookForFile;
            }
            //確認有沒有這個檔案 有的話回傳 true
            //當不找到檔案 會須一直要求輸入直到找到為止
            public static void Welcome () {
                System.out.println("Welcome to the game of Mad Libs.");
                System.out.println("I will ask you to provide various words");
                System.out.println("and phrases to fill in a story.");
                System.out.println("The result will be written to an output file.");
            }
            public static String input () {
                Scanner in = new Scanner(System.in);
                return in.nextLine();
            }

            public static String newSentence(String origin/*原先的句子*/  ){// 從原的句子找出<>並取代並傳到新的裡面 但回傳原來的是甚麼詞性 String iwanttoplace/*我想替換的字*/
                int start, end;
                String speech, myword, whole;
                do {
                    if(origin.contains("<")) {
                        start = origin.indexOf("<");
                        end = origin.indexOf(">");
                        speech = origin.substring(start + 1, end);
                        char firstWord = speech.toLowerCase().charAt(0);
                        if (firstWord == 'a' || firstWord == 'e' || firstWord == 'i' || firstWord == 'o' || firstWord == 'u') {
                            System.out.print("Please type an " + speech + ": ");
                        } else {
                            System.out.print("Please type a " + speech + ": ");
                        }
                        myword = input();
                        whole = origin.substring(0, start) + myword + origin.substring(end + 1, origin.length()-1);
                        origin = whole;
                    }
                    else {
                        whole = origin;
                    }
                } while (origin.indexOf("<") >= 1);
                return whole;
            }

        }






