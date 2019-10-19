package chapter10.chart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class RootController implements Initializable {

	@FXML
	private PieChart pieChart;
	@FXML
	private BarChart barChart;
	@FXML
	private AreaChart areaChart;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<PieChart.Data> pieChartList = FXCollections.observableArrayList();
		pieChartList.add(new PieChart.Data("AWT", 10));
		pieChartList.add(new PieChart.Data("SWING", 20));
		pieChartList.add(new PieChart.Data("SWT", 30));
		pieChartList.add(new PieChart.Data("JAVAFX", 40));

		pieChart.setData(pieChartList);
		// pieChart -> pieChart.Data 를 pieChart에 넣는다.

		ObservableList<XYChart.Data> barChartList = FXCollections.observableArrayList();
		barChartList.add(new XYChart.Data("2015", 10));
		barChartList.add(new XYChart.Data("2016", 60));
		barChartList.add(new XYChart.Data("2017", 30));
		barChartList.add(new XYChart.Data("2018", 40));

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("남자");
		series1.setData(barChartList);
		barChart.getData().add(series1);

		ObservableList<XYChart.Data> barChartList2 = FXCollections.observableArrayList();
		barChartList2.add(new XYChart.Data("2015", 30));
		barChartList2.add(new XYChart.Data("2016", 20));
		barChartList2.add(new XYChart.Data("2017", 70));
		barChartList2.add(new XYChart.Data("2018", 55));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("여자");
		series2.setData(barChartList2);
		barChart.getData().add(series2);
		// barChart -> barChart는 XYChart.Data 타입을 사용하고 XYChart의 Series를
		// 사용한다.(XYChart.Series)
		// -> 이름을 정하고 데이터에 List를 넣는다. -> barChart의 getData의 add에 series를 추가한다.

		ObservableList<XYChart.Data> barChartList3 = FXCollections.observableArrayList();
		barChartList3.add(new XYChart.Data("2015", 12));
		barChartList3.add(new XYChart.Data("2016", 23));
		barChartList3.add(new XYChart.Data("2017", 22));
		barChartList3.add(new XYChart.Data("2018", 19));

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("평균 온도");
		series3.setData(barChartList3);
		areaChart.getData().add(series3);

	}
}
