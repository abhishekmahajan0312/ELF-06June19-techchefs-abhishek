var sec = 0;//variable for seconds elapsed
var min = 0;//variable for minutes elapsed
var endTime;////variable for total time
var timer;//variable for the timer

//to start the timer on click of start button
function startTimer() {
    endTime = document.getElementById("timeText").value; //set the end time from the text field
    timer = setInterval(progress, 1000);// set the timeout interval for 1 second
}
// Function to progress the timer
function progress() {
    //condition to check if endtime is reached or not
    if (min == endTime) {
        document.getElementById("seconds").innerHTML = "00";
        clearInterval(timer);// after time completes stop the timer
    }
    //if seconds become equal to 60 then set seconds to 0 and increment min by 1
    else if (sec == 60) {
        sec = 0;
        min++;
        if (min < 10) {
            document.getElementById("minutes").innerHTML = "0" + min;// append 0 if minutes are less than 10
        }
        else {
            document.getElementById("minutes").innerHTML = min;
        }
    }
    //else increment seconds by 1
    else {
        if (sec < 10) {
            document.getElementById("seconds").innerHTML = "0" + sec;// append 0 if seconds are less than 10
        }
        else {
            document.getElementById("seconds").innerHTML = sec;
        }
    }
    sec++;
}