package application;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class SampleController {
	@FXML
	private TextArea textArea;
	@FXML
	private MenuItem openBtn;
	@FXML
	private MenuItem saveBtn;
	
	String st;

	// Event Listener on MenuItem[#openBtn].onAction
	@FXML
	public void onClickOpen(ActionEvent event) throws IOException {
		// TODO Autogenerated
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("."));
		fc.getExtensionFilters().add(new ExtensionFilter("テキストファイル", "*.txt"));
		File fname = fc.showOpenDialog(Main.mainStage);
		FileReader filereader = new FileReader(fname);
		int ch = filereader.read();
		String a = "";
		while(ch != -1){
		    a += (char)ch;

		    ch = filereader.read();
		}
		filereader.close();
		textArea.setText(a);
		
	}
	
	public void onClickSave(ActionEvent event) throws IOException {
		// TODO Autogenerated
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("."));
		fc.getExtensionFilters().add(new ExtensionFilter("テキストファイル", "*.txt"));
		File fname = fc.showSaveDialog(Main.mainStage);
		if (fname != null && fname.exists()) {
			fname.delete();
		}else if(fname != null){
			try {
				fname.createNewFile();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		FileWriter filewriter = new FileWriter(fname);
		filewriter.write(textArea.getText());
		filewriter.close();
		
	}
	
}
