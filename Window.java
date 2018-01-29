import javax.swing.JFrame;
 
public class Window extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна
 
	public Window(){
		super("My First Window"); //Заголовок окна
		setBounds(100, 300, 640, 480); //Если не выставить размер и положение - то окно будет мелкое и незаметное
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
	}
 
	public static void Window(String[] args) { //эта функция может быть и в другом классе
		Window app = new Window(); //Создаем экземпляр нашего приложения
		app.setVisible(true); //С этого момента приложение запущено!
	}
}
