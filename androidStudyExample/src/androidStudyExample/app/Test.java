package androidStudyExample.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame{

	JPanel panel = new JPanel(); //판넬 만들기 
	JButton button = new JButton(); //버튼 만들기 
	
	public Test() {
		super("Test"); // 프레임에 Test 표시
		
		panel.add(button);
		button.setText("BUTTON");
		
		add(panel);//판넬 추가 
		setSize(500,500);// 판넬 사이즈 
		setVisible(true);//판넬 표시 유무 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 엑스표시를 누르면 종료
		
		//ActionListener 만들기 (무명 객체)
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//버튼의 text가 BUTTON 이면 버튼의 text를 Click!으로 세팅  
				// 아니면 HELLO 로 세팅 
				if(button.getText().equals("BUTTON")) {
					button.setText("Click!");
				}else {
					button.setText("HELLO");
				}
			}
		});
		
		
	}
	public static void main(String[] args) {
		new Test();
	}

}
