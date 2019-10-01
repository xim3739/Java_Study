package chapter10.media_player;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class RootController implements Initializable {
	
	@FXML private ImageView imageView;
	@FXML private MediaView mediaView;
	@FXML private Button playButton;
	@FXML private Button pauseButton;
	@FXML private Button stopButton;
	@FXML private ProgressBar progressBar;
	@FXML private ProgressIndicator progressIndicator;
	@FXML private Slider soundSlider;
	@FXML private Label labelTime;
	
	private boolean endOfMedia = false;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Media media = new Media(getClass().getResource("media/video.m4v").toString());
		// 미디어뷰를 진행하기 위해서 미디어 객체를 가져온다. (스트림으로 전송하기 때문)
		
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		// 미디어 플레이어 객체를 만든다.
		
		mediaView.setMediaPlayer(mediaPlayer);
		// 미디어뷰에 미디어 플레이어를 세팅한다.
		
		soundSlider.setValue(50.0);
		mediaPlayer.setVolume(soundSlider.getValue()/100.0);
		
		soundSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				mediaPlayer.setVolume(newValue.doubleValue()/100.0);
			}
		});
		//슬라이더와 미디어 플레이어 소리를 세팅
		
		mediaPlayer.setOnReady(new Runnable() {
			
			@Override
			public void run() {
				playButton.setDisable(false);
				stopButton.setDisable(true);
				pauseButton.setDisable(true);
				if (mediaPlayer.isAutoPlay()) {
					mediaView.setVisible(false);
				}
				mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {

					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,
							Duration newValue) {
						double totalTime = mediaPlayer.getTotalDuration().toSeconds();
						double currentTime = mediaPlayer.getCurrentTime().toSeconds();
						progressBar.setProgress(currentTime/totalTime);
						progressIndicator.setProgress(currentTime/totalTime);
						labelTime.setText((int)currentTime + " / " + (int)totalTime);
					}
				});
				//progressBar 이벤트 설정 property 이용
				
			}
		});
		// 준비상태
		
		mediaPlayer.setOnPlaying(() -> {
			playButton.setDisable(true);
			stopButton.setDisable(false);
			pauseButton.setDisable(false);
		});
		
		mediaPlayer.setOnPaused(() -> {
			playButton.setDisable(false);
			stopButton.setDisable(false);
			pauseButton.setDisable(true);
		});
		
		mediaPlayer.setOnStopped(() -> {
			playButton.setDisable(false);
			stopButton.setDisable(true);
			pauseButton.setDisable(true);
		});
		
		mediaPlayer.setOnEndOfMedia(() -> {
			playButton.setDisable(false);
			stopButton.setDisable(true);
			pauseButton.setDisable(true);
			endOfMedia = true;
			progressBar.setProgress(1.0);
			progressIndicator.setProgress(1.0);
			labelTime.setText("완료");
			
		});
		
		playButton.setOnAction((e) -> {
			if(endOfMedia) {
				mediaPlayer.stop();
				mediaPlayer.seek(mediaPlayer.getStartTime());
			}
			mediaPlayer.play();
			endOfMedia = false;
		});
		
		stopButton.setOnAction((e) -> {
			mediaPlayer.stop();
		});
		
		pauseButton.setOnAction((e) -> {
			mediaPlayer.pause();
		});
		
	}
}