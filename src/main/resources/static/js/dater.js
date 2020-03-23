							var myDate=new Date()
							var year=myDate.getYear()
							if(year<1000)
							year+=1900
							var day=myDate.getDay()
							var month=myDate.getMonth()
							var daym=myDate.getDate()
							if(daym<10)
							daym="0"+daym
							var dayArray=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
							var monthArray=new Array("January","February","March","April","May","June","July","August","September","October","November","December")
							document.write(""+dayArray[day]+", "+monthArray[month]+" "+daym+", "+year+"")