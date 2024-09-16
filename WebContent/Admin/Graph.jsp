<%@page import="admin.vo.CarBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Charts - SB Admin</title>
        <link href="Admin/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
		
    </head>
    <%
    ArrayList<CarBean> CarList=(ArrayList)request.getAttribute("CarList");
    ArrayList<CarBean> cb=(ArrayList<CarBean>)request.getAttribute("cb");
    String title=(String)request.getAttribute("title");
    if(title==null){title="제조사";}
    ArrayList target=new ArrayList();
    ArrayList count= new ArrayList();
    if(cb!=null){
    for(int i = 0; i < cb.size(); i++){
    	target.add("'"+cb.get(i).getCar_maker()+"'");
    	count.add(cb.get(i).getCar_id());
    	//system.out.print(cb.get(i).getCar_id());
   	 }
    }
    %>
   <jsp:include page="/inc/topleft.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4"><%=title%> &nbsp 차량그래프 </h1> 
                        
						         	
                       

                       
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-chart-area mr-1"></i>

                            
      <select class="custom-select" onchange="if(this.value) location.href=(this.value);" style="width: 200px; margin-right: 5px;">
                             <option value="">선택하세요.
                             <option value="GraphPro.ad?target1=car_maker&&title=Maker ">Maker
                            <option value="GraphPro.ad?target1=car_type&&title=Type ">Type
                            <option value="GraphPro.ad?target1=car_name&&target2=car_maker='Hyundai'&&title=Hyundai ">Hyundai
                            <option value="GraphPro.ad?target1=car_name&&target2=car_maker='Kia'&&title=Kia ">Kia
                            <option value="GraphPro.ad?target1=car_name&&target2=car_maker='Chevrolet'&&title=Chevrolet ">Chevrolet
                            <option value="GraphPro.ad?target1=car_name&&target2=car_maker='Bmw'&&title=BMW ">BMW
                            <option value="GraphPro.ad?target1=car_name&&target2=car_maker='Benz'&&title=Benz ">Benz
                            <option value="GraphPro.ad?target1=car_name&&target2=car_maker='Audi'&&title=Audi ">Audi
     </select>         
                            </div>
                            <div class="card-body"><canvas id="lineChart" width="1000" height="200"></canvas></div>                   
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar mr-1"></i>
                                        Bar Chart Example
                                    </div>
                                    <div class="card-body"><canvas id="barChart" width="300" height="300"></canvas></div>
                             
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                
                                    <div class="card-header">
                                        <i class="fas fa-chart-pie mr-1"></i>
                                        Pie Chart Example
                                    </div>
                                    <div class="card-body"><canvas id="pieChart" width="300" height="300"></canvas></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
              
            </div>
        </div>
       <script type="text/javascript">
       var target=<%=target%>
       var targetcount=<%=count%>
      //파이 그래프 스크립트
       var data = {
    		    datasets: [{
    		        data: targetcount,
    		        backgroundColor: [
    		        	'rgba(255, 99, 132, 1)',
    					'rgba(54, 162, 235, 1)',
    					'rgba(255, 206, 86, 1)',
    					'rgba(75, 192, 192, 1)',
    					'rgba(153, 102, 255, 1)',
    					'rgba(255, 159, 64, 1)'
    		        ],
    		        label: 'My dataset' // for legend
    		    }],
    		    labels: target
    		};

    		var pieOptions = {
    				responsive: false,	
    		  events: false,
    		  animation: {
    		    duration: 500,
    		    easing: "easeOutQuart",
    		    onComplete: function () {
    		      var ctx = this.chart.ctx;
    		      ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontFamily, 'normal', Chart.defaults.global.defaultFontFamily);
    		      ctx.textAlign = 'center';
    		      ctx.textBaseline = 'bottom';

    		      this.data.datasets.forEach(function (dataset) {

    		        for (var i = 0; i < dataset.data.length; i++) {
    		          var model = dataset._meta[Object.keys(dataset._meta)[0]].data[i]._model,
    		              total = dataset._meta[Object.keys(dataset._meta)[0]].total,
    		              mid_radius = model.innerRadius + (model.outerRadius - model.innerRadius)/2,
    		              start_angle = model.startAngle,
    		              end_angle = model.endAngle,
    		              mid_angle = start_angle + (end_angle - start_angle)/2;

    		          var x = mid_radius * Math.cos(mid_angle);
    		          var y = mid_radius * Math.sin(mid_angle);

    		          ctx.fillStyle = '#fff';
    		          if (i == 3){ // Darker text color for lighter background
    		            ctx.fillStyle = '#444';
    		          }
    		          var percent = String(Math.round(dataset.data[i]/total*100)) + "%";  
    		         var count=String(dataset.data[i])+"대";
    		          //Don't Display If Legend is hide or value is 0
    		          if(dataset.data[i] != 0 && dataset._meta[0].data[i].hidden != true) {
    		        	ctx.fillText(target[i], model.x + x, model.y + y-15);
    		            ctx.fillText(count, model.x + x, model.y + y);
    		            // Display percent in another line, line break doesn't work for fillText
    		            ctx.fillText(percent, model.x + x, model.y + y + 15);
    		          }
    		        }
    		      });               
    		    }
    		  }
    		};

    		var pieChartCanvas = document.getElementById('pieChart');
    		var pieChart = new Chart(pieChartCanvas, {
    		  type: 'doughnut', // or doughnut
    		  data: data,
    		  options: pieOptions
    		});
    		
    		// 막대그래프 스크립트
    var myBarChartctx = document.getElementById('barChart');
	var myBarChart = new Chart(myBarChartctx, {
	    type: 'bar',
	    data: {
			labels: target,
			datasets: [{
				label: "Bar Graph",
				data: targetcount,
				backgroundColor: [
						'rgba(0, 0, 0, 0)'
				],
				borderColor: [
						'rgba(255, 99, 132, 1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
				],
				borderWidth: 3
			}]
		},
		options: {
			legend:false,
			render: 'value',
			responsive: false,
			tooltips: {
				enabled: false
			},
			hover: {
				animationDuration: 0
			},
			animation: {
				duration: 1,
				onComplete: function () {
					var chartInstance = this.chart,
						ctx = chartInstance.ctx;
					ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
					ctx.fillStyle = 'purple';
					ctx.textAlign = 'center';
					ctx.textBaseline = 'bottom';

					this.data.datasets.forEach(function (dataset, i) {
						var meta = chartInstance.controller.getDatasetMeta(i);
						meta.data.forEach(function (bar, index) {
							var data = dataset.data[index];							
							ctx.fillText(data, bar._model.x, bar._model.y-5);
							
						});
					});
				}
			},
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero: true,
						stepSize : 100,
						fontSize : 14,
					}
				}]
			}
		}
	});
	
	//곡선그래프 스크립트
	var myAreaChartctx = document.getElementById('lineChart');
	var myAreaChart = new Chart(myAreaChartctx, {
	    type: 'line',
	    data: {
			labels: target,
			datasets: [{
				label: 'Line Graph',
				data: targetcount,
				backgroundColor: [
						'rgba(0, 0, 0, 0)'
				],
				borderColor: [
						'rgba(255, 99, 132, 1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
				],
				borderWidth: 3
			}]
		},
		options: {
			legend:false,
			render: 'value',
			responsive: false,
			tooltips: {
				enabled: false
			},
			hover: {
				animationDuration: 0
			},
			animation: {
				duration: 1,
				onComplete: function () {
					var chartInstance = this.chart,
						ctx = chartInstance.ctx;
					ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
					ctx.fillStyle = 'purple';
					ctx.textAlign = 'center';
					ctx.textBaseline = 'bottom';

					this.data.datasets.forEach(function (dataset, i) {
						var meta = chartInstance.controller.getDatasetMeta(i);
						meta.data.forEach(function (bar, index) {
							var data = dataset.data[index];							
							ctx.fillText(data, bar._model.x, bar._model.y-5);
							
						});
					});
				}
			},
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero: true,
						stepSize : 100,
						fontSize : 14,
					}
				}]
			}
		}
	});
       
       </script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
                <script src="Admin/assets/demo/datatables-demo.js"></script>
                <script src="Admin/js/scripts.js"></script>
                        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
                
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="assets/demo/chart-pie-demo.js"></script>
    </body>
</html>
    