import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class programa {

    public static void main(String[] args)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        String original_username = "user01";
        String original_password = "LAtina132*";
        String original_address  = "";
        String original_phone  = "";
        String original_dni  = "";
        String original_nationality  = "";
        int original_producto = 0;

        boolean password_is_correct = false;
        boolean is_option_salir = false;
        String[ ] frutas = {"Manzanas", "Peras", "Uvas","Melones", "Zapallo"};
        System.out.println("########  Bienvenido! ########");
        System.out.println(" Ingrese un Usuario: ");
        String username = sc.nextLine();
        for(int x=0;x<=2;x++){
            System.out.println("\u001B[0m Introduzca una contraseña: ");
            String password = sc.nextLine();
            if (original_username.equals(username.toLowerCase()) && original_password.equals(password)){
                password_is_correct = true;
                break;
            }
            System.out.println("\u001B[31m La contraseña es invalida ");
        }
        if (!password_is_correct){
            System.out.println("\u001B[31m Ha superado el limite de intentos..");
            System.exit(0);

        }
        System.out.println("\u001B[32m Ha iniciado sesión correctamente!");
        while(true){
            System.out.println("\u001B[0m################################ Menu m################################");
            System.out.println("\u001B[0m Nota: Ingrese el numero de la acción que desea realizar");
            System.out.println("\u001B[0m 1.) Cambiar Contraseña");
            System.out.println("\u001B[0m 2.) Llenar información de su perfil");
            System.out.println("\u001B[0m 3.) Pedidos");
            System.out.println("\u001B[0m 4.) Salir");
            System.out.println("\u001B[0m Ingrese la opción de menu a la que desea ingresar: ");
            String menu = sc.nextLine();
            switch(menu){
                case "1":
                    System.out.println("\u001B[0m######## Cambiar Contraseña ########");
                    System.out.println("\u001B[0m Ingrese su nueva contraseña");
                    original_password = sc.nextLine();
                    System.out.println("\u001B[32m La contraseña se ha cambiado exitosamente!");
                    System.out.println("\u001B[30m La nueva contraseña que usted utilizara es:  "+ original_password);

                    break;
                case "2":
                    System.out.println("\u001B[0m######## Datos Personales ########");
                    System.out.println("\u001B[0m Ingrese su dirección");
                    original_address = sc.nextLine();
                    System.out.println("\u001B[0m Ingrese su número de teléfono");
                    original_phone = sc.nextLine();
                    System.out.println("\u001B[0m Ingrese su DNI");
                    original_dni = sc.nextLine();
                    System.out.println("\u001B[0m Ingrese su Nacionalidad");
                    original_nationality = sc.nextLine();
                    System.out.println("\u001B[32m Su información personal se ha actualizado exitosamente!");
                    System.out.println("\u001B[32m Sus datos son:  ");
                    System.out.println("\u001B[32m Dirección: "+original_address);
                    System.out.println("\u001B[32m Telefono: "+original_phone);
                    System.out.println("\u001B[32m DNI "+original_dni);
                    System.out.println("\u001B[32m Nacionalidad: "+original_nationality );

                    break;
                case "3":
                    System.out.println("\u001B[0m######## Productos ########");
                    System.out.println("\u001B[0m Nota: Ingrese el numero de la producto que desea comprar");
                    while(true){
                        try{
                            for(int x=0;x < frutas.length;x++){
                                System.out.println("\u001B[0m "+(x)+".) "+frutas[x]);
                            }
                            String value = sc.nextLine();
                            original_producto =  Integer.parseInt(value);
                            if (original_producto >=0 && original_producto < frutas.length){
                                break;
                            }
                            System.out.println("\u001B[31m El numero ingresado esta fuera del rango de productos.");
                        }catch(Exception error){
                            System.out.println(error);
                            System.out.println("\u001B[31m El opción ingresa no es valida.");
                        }
                    }
                    System.out.println("\u001B[32m Se ha seleccionado el producto: "+frutas[original_producto]+"!");
                    break;
                case "4":
                    System.out.println("\u001B[0m######## Salir ########");
                    System.out.println("\u001B[32m Su orden fue completada con éxito, a la hora tal "+dtf.format(LocalDateTime.now())+" - La misma será enviada a su domicilio");
                    is_option_salir = true;
                    break;
                default:
                    System.out.println("\u001B[31m La opción seleccionada es invalida ");
            }
            if (is_option_salir){
                break;
            }
        }

    }
}