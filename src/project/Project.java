package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Project {

    public static void main(String[] args) {

        int count = 0;//عدد يلزمني في تحديد موقع الاضافة 
        ArrayList<Products> data = new ArrayList<>();//اراي ليست من نوع  السوبر كلاس 
        File dataFile = new File("C:\\Users\\pc\\Desktop\\Project\\src\\project\\data.text");//تحديد موقع الملف الذي نريد نقرأ منه
        try {
            Scanner read = new Scanner(dataFile);//سكنر للقراءة من الملف
            //عملية القراءة
            while (read.hasNextLine()) {//بفحض طالما المؤشر تاع سكنر في بعده سطر 

                String line = read.nextLine();//هنا بقرأ السطر
                String[] line_array = line.split(",");//هنا نعمله سبليت بناء على الفاصلة وهذه الميثود برجع منها مصفوفة من نوع سترينج

                if (line_array[line_array.length - 1].equalsIgnoreCase("d")) {//نفحص إذا كان العنصر الأخير هو اي من الحروف التي تدل على نوع المنتج
                    //لو كان حرف دي
                    int id = Integer.parseInt(line_array[0]);//نخزن اول عنصر وهو الرقم

                    String name = line_array[1];//نخزن ثاني عنصر  وهو الأسم

                    String descreption = line_array[2];//نخزن ثالث عنصر وهو الوصف

                    int price = Integer.parseInt(line_array[3]);//نخزن رابع عنصر وهو السعر

                    int height = Integer.parseInt(line_array[4]);//نخزن خامس عنصر وهو الارتفاع

                    int width = Integer.parseInt(line_array[5]);//نخزن سادس عنصر وهو العرض

                    String type = line_array[6];//نخزن سابع عنصر وهو نوع المنتج

                    DProducts object = new DProducts(id, name, descreption, price, height, width, type);//إنشاء اوبجكت وعطاءه القيم

                    data.add(count, object);//نضيف الاوبجكت في الاراي ليست التي من نوع السوبر كلاس في الموقع كاونت 
                    count++;//زيادة العداد
                } else if (line_array[line_array.length - 1].equalsIgnoreCase("w")) {//نفحص إذا كان العنصر الأخير هو اي الحروف التي تدل على نوع المنتج
                    //تكرار السابق مع تغيير بسيط 
                    int id = Integer.parseInt(line_array[0]);

                    String name = line_array[1];

                    String descreption = line_array[2];

                    int price = Integer.parseInt(line_array[3]);

                    int weight = Integer.parseInt(line_array[4]);

                    String type = line_array[5];

                    WProducts object = new WProducts(id, name, descreption, price, weight, type);
                    data.add(count, object);
                    count++;

                }

            }
            read.close();//إغلاق سكنر القراءة 
        } catch (FileNotFoundException ex) {
            System.out.println("************************");
            System.err.println("File Not Found Exception");
            System.out.println("************************");

        }

        while (true) {//لوب غير منتهية إلا بإدخال الرقم سبعة
            //أول ما يبدأ البرنامج يتم عرض القائمة التالية
            System.out.println("1_Show all products: ");
            System.out.println("2_Add a product: ");
            System.out.println("3_Delete a product: ");
            System.out.println("4_Edit a product: ");
            System.out.println("5_Calculate the total price: ");
            System.out.println("6_Save data to the file: ");
            System.out.println("7_Exit: ");
            System.out.println("Enter your choice: ");
            // System.out.println("*****");
            int select = 0;
            Scanner input_User = new Scanner(System.in);//إنشاء سكنر الإدخال من المستخدم
            try {

                select = input_User.nextInt();//تخزين المدخل من المستخدم لأحد الخيارات
            } catch (Exception ex) {
                System.out.println("********************************");
                System.out.println(ex.toString());

            }
            if (select == 1) {
                //الخيارالأول  طباعة تقرير عن كل نوع من المنتجات حسب رغبة المستخدم
                input_User.nextLine();

                System.out.print("Enter the type: ");//مطالبة المستخدم بإدخال نوع البيانات التي يريد طباعة التقرير لها
                String type = input_User.nextLine();//تخزين المدخل 
                if (type.equalsIgnoreCase("d")) {//فحص إذا كان الحرف المدخل احد النوعين  لوكان من النوع الأول
                    for (int index_1 = 0; index_1 < data.size(); index_1++) {//لوب تمر على كل الاراي ليست
                        if (data.get(index_1) instanceof DProducts) {//نفحص إذا الاوبجكت اللي وصله ينتمي للنوع الاول
                            DProducts temp = (DProducts) data.get(index_1);//نعمله كاستنق
                            System.out.println("product: " + temp.Report_Products());//طباعة التقرير 
                        }
                    }
                } else if (type.equalsIgnoreCase("w")) {//فحص إذا كان الحرف المدخل احد النوعين  لوكان من النوع االثاني
                    for (int index_1 = 0; index_1 < data.size(); index_1++) {//لوب تمر على كل الاراي ليست
                        if (data.get(index_1) instanceof WProducts) {//نفحص إذا الاوبجكت اللي وصله ينتمي للنوع الثاني
                            WProducts temp = (WProducts) data.get(index_1);//نعمله كاستنق

                            System.out.println("product: " + temp.Report_Products());//طباعة التقرير 

                        }
                    }
                } else {
                    System.out.println("********************");
                    System.out.println("Invalid product type");
                    System.out.println("********************");
                }

            } else if (select == 2) {
                //الخيار الثاني يختص في إضافة منتجات
                input_User.nextLine();
                System.out.print("Enter the type: ");//مطالبة المستخدم بنوع النتج الذي يريد إضافته
                String typeadd = input_User.nextLine();
                if (typeadd.equalsIgnoreCase("d")) {//نفحص لو كان دي
                    //نقوم بمطالبته بإدخل البيانات الخاصة بهذا النوع
                    try {
                        System.out.print("Enter the product id: ");
                        int id = input_User.nextInt();
                        input_User.nextLine();
                        System.out.print("Enter the product name: ");
                        String name = input_User.nextLine();

                        System.out.print("Enter the product dascreption: ");
                        String des = input_User.nextLine();

                        System.out.print("Enter the product price: ");
                        int price = input_User.nextInt();
                        input_User.nextLine();
                        System.out.print("Enter the product height: ");
                        int height = input_User.nextInt();

                        System.out.print("Enter the product width: ");
                        int width = input_User.nextInt();

                        String type = "d";

                        DProducts object = new DProducts(id, name, des, price, height, width, type);//إدخال البيانات في الاوبجكت

                        data.add(count, object);//حفظ الأوبجكت في الاراي ليست
                        count++;//زيادة العداد
                        System.out.println("Added successfully");//طباعة رسالة تفيد بنجاح عملية الإضافة
                    } catch (Exception ex) {
                        System.out.println("********************************");
                        System.out.println(ex.toString());
                        System.out.println("********************************");

                    }
                } else if (typeadd.equalsIgnoreCase("w")) {//نفحص لو كان من دبليو
                    //نقوم بمطالبته بإدخل البيانات الخاصة بهذا النوع
                    try {
                        System.out.print("Enter the product id: ");
                        int id = input_User.nextInt();
                        input_User.nextLine();
                        System.out.print("Enter the product name: ");
                        String name = input_User.nextLine();

                        System.out.print("Enter the product dascreption: ");
                        String des = input_User.nextLine();

                        System.out.print("Enter the product price: ");
                        int price = input_User.nextInt();
                        input_User.nextLine();
                        System.out.print("Enter the product weight: ");
                        int weight = input_User.nextInt();

                        String type = "w";
                        WProducts object = new WProducts(id, name, des, price, weight, type);//إدخال البيانات في الاوبجكت

                        data.add(count, object);//حفظ الاوبجكت في الاراي ليست
                        count++;//زيادة العداد
                        System.out.println("Added successfully");//طباعة رسالة تفيد بنجاح عملية الإضافة
                    } catch (Exception ex) {
                        System.out.println("********************************");
                        System.out.println(ex.toString());
                        System.out.println("********************************");
                    }
                } else {
                    System.out.println("********************");
                    System.out.println("Invalid product type");
                    System.out.println("********************");
                }

            } else if (select == 3) {
                //الخيار الثالث يختص بحذف منتج بناءا على رقم المنتج الذي يدخله المستخدم
                input_User.nextLine();
                try {
                    System.out.print("Enter the product id: ");//مطالبة المستخدم بإدخل رقم المنتج الذي يريد حذفه
                    int idDelet = input_User.nextInt();//تخزين الرقم

                    for (int index_2 = 0; index_2 < data.size(); index_2++) {//لوب تمر على الاراي ليست
                        if (data.get(index_2).getId() == idDelet) {//تفحص إذا الاوبجكت اللي وصلتله الرقم تبعه يساوي الرقم المدخل من المستخدم
                            data.remove(index_2);//لو كان الرقم متساوي يتم حدف المنتج
                            System.out.println("Deletion successful");//طباعة رسالة تفيد بنجاح عملية الحذف
                        }/*else{
                             System.out.println("***************************************");
                            System.out.println("The product number you entered is wrong");
                            System.out.println("***************************************");
                            
                        }
                         */
                    }

                } catch (Exception ex) {
                    System.out.println("********************************");
                    System.out.println(ex.toString());
                    System.out.println("********************************");
                }

            } else if (select == 4) {
                //هذا الخيار يختص في التعديل على المنتجات بمجرد انا يقوم المستخدم بإدخل رقم النتج الذي يريد التعديل عليه
                input_User.nextLine();
                int id_user = 0;
                try {
                    System.out.print("Enter the product id: ");//مطالبة المستخدم بإدخال رقم المنتج الذي يريد التعديل عليه
                    id_user = input_User.nextInt();
                } catch (Exception ex) {
                    System.out.println("********************************");
                    System.out.println(ex.toString());
                    System.out.println("********************************");
                }

                for (int index_4 = 0; index_4 < data.size(); index_4++) {
                    if (data.get(index_4).getId() == id_user && data.get(index_4) instanceof DProducts) {//الفحص 
                        try {
                            System.out.println("Products: " + data.get(index_4).Report_Products());//عرض البيانات
                            //مطالبة المستخدم بالبيانات الجديدة
                            System.out.print("Enter the product new id: ");
                            int id = input_User.nextInt();
                            input_User.nextLine();
                            System.out.print(" Enter the product new name: ");
                            String name = input_User.nextLine();

                            System.out.print("Enter the product new dascreption : ");
                            String des = input_User.nextLine();

                            System.out.print("Enter the product new price : ");
                            int price = input_User.nextInt();
                            input_User.nextLine();
                            System.out.print("Enter the product new height : ");
                            int height = input_User.nextInt();

                            System.out.print("Enter the product new width : ");
                            int width = input_User.nextInt();

                            String type = "d";
                            DProducts objectNew = new DProducts(id, name, des, price, height, width, type);//إدخال البيانات في الاوبجكت
                            data.remove(index_4);//حذف الاوبجكت السابق
                            data.add(index_4, objectNew);//حفظ الاوبجكت الجديد في مكان الاوبجكت السابق
                            System.out.println("Edited successfully");
                        } catch (Exception ex) {
                            System.out.println("********************************");
                            System.out.println(ex.toString());
                            System.out.println("********************************");
                        }
                    } else if (data.get(index_4).getId() == id_user && data.get(index_4) instanceof WProducts) {//الفحص
                        try {
                            System.out.println("products: " + data.get(index_4).Report_Products());//عرض البيانات 
                            //مطالبة المستخدم بإدخال البيانات الجديدة
                            System.out.print("Enter the product new id: ");
                            int id = input_User.nextInt();
                            input_User.nextLine();
                            System.out.print("Enter the product new name: ");
                            String name = input_User.nextLine();

                            System.out.print("Enter the product new dascreption: ");
                            String des = input_User.nextLine();

                            System.out.print("Enter the product new price: ");
                            int price = input_User.nextInt();
                            input_User.nextLine();
                            System.out.print("Enter the product new weight: ");
                            int weight = input_User.nextInt();

                            String type = "w";
                            WProducts objectNew = new WProducts(id, name, des, price, weight, type);//إدخال البيانات في الاوبجكت
                            data.remove(index_4);//حذف الاوبجكت السابق
                            data.add(index_4, objectNew);//حفظ الاوبجكت الجديد مكان الاوبجكت الاول
                            System.out.println("Edited successfully");
                        } catch (Exception ex) {
                            System.out.println("********************************");
                            System.out.println(ex.toString());
                            System.out.println("********************************");
                        }

                    }/*else{
                    System.out.println("***************************************");
                    System.out.println("The product number you entered is wrong");
                    System.out.println("***************************************");
                    
                }*/
                }

            } else if (select == 5) {
                //الخيار الخامس يختص في حساب السعر الكلي للمنتجات
                int totlPrice = 0;//افترضت ان السعر الكلي صفر
                for (int index_5 = 0; index_5 < data.size(); index_5++) {//لوب تمر على جميع عناصر الاراي ليست
                    totlPrice += data.get(index_5).Total_price();//إضافة السعر لكل منتج على السعر الكلي 
                }
                System.out.println("totlPrice= " + totlPrice);//طباعة السعر الكلي
                //input_User.nextLine();
            } else if (select == 6) {
                //الخيار السادس يختص في حفظ البيانات بعد الاضافة والحدف والتعديل في الملف
                try {
                    FileWriter fr = new FileWriter(dataFile);
                    PrintWriter pr = new PrintWriter(fr, true);

                    for (int counter = 0; counter < data.size(); counter++) {
                        if (data.get(counter) instanceof DProducts) {
                            DProducts p = (DProducts) data.get(counter);
                            pr.println(p.getId() + "," + p.getName() + "," + p.getDescription() + "," + p.getPrice() + "," + p.getHeight() + "," + p.getWidth() + "," + p.getTypeProduct());

                        } else if (data.get(counter) instanceof WProducts) {
                            WProducts p = (WProducts) data.get(counter);
                            pr.println(p.getId() + "," + p.getName() + "," + p.getDescription() + "," + p.getPrice() + "," + p.getWeight() + "," + p.getTypeProduct());
                        }

                    }
                    fr.close();
                    pr.close();

                    System.out.println("saved");
                } catch (IOException ex) {
                    System.out.println("********************************");
                    System.out.println(ex.toString());
                    System.out.println("********************************");
                }

            } else if (select == 7) {
                // الخيار السادس يختص بالخروج من البرنامج
                break;
            } else {
                System.out.println("Wrong entry");
                System.out.println("********************************");
            }

        }

    }

}


/*
1,Wall frame,Wall brackets containing the Java logo,100,50,50,d
2,Bread,Bread made of barley,200,30,w
3,carpet,Prayer rug,300,30,30,d
4,Meat,Frozen meat,400,20,w
 */
