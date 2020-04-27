import java.util.Scanner;

public class ProductsService {

    public String service() throws Exception {
        ProductStorage productStorage = new ProductStorage();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду ");
            String command = input.nextLine();
            if (command.equals("find")) {
                System.out.println("Введите пример для поиска:");
                String title = input.nextLine();
                System.out.println(productStorage.findByTittle(title));

            } else if (command.equals("delete")) {
                System.out.println("Введите id строки для удаления");
                int id = Integer.parseInt(input.nextLine());
                productStorage.delete(id);

            } else if (command.equals("update")) {
                System.out.println("Введите id строки для редактирования");
                int id = Integer.parseInt(input.nextLine());
                System.out.println("Введите новое значение title:");
                String title = input.nextLine();
                productStorage.update(id, title);
                System.out.println(productStorage.findByTittle(title));

            } else if (command.equals("insert")) {
                CreateProducts createProducts = new CreateProducts();
                createProducts.createProducts();
            }
        }
    }
}
