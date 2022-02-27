const city = "New York, NY";
const appid = 'bad6f8a83fe5c5b46cf478d12a8c638c';
const weatherUrl = `http://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${appid}&units=imperial`;
const fiveDayUrl = `http://api.openweathermap.org/data/2.5/forecast?q=${city}&appid=${appid}&units=imperial`;




function* me() {
  const response = yield fetch(weatherUrl);
  const weather = yield response.json();

  const fiveDay = yield fetch(fiveDayUrl).then(r => r.json());

  console.log(fiveDay);
  console.log(weather);
  return { fiveDay, weather};
}

///////////////////

const meGenerator = me();
assistant(meGenerator)
  .catch(function rejectionReaction(error) {
    console.log("recover from error:" + error);
  })
  .then(function(result){
    console.log(`Assistant is done`,result);
  })















function assistant(generator) {

  return new Promise(function executor(resolve, reject) {
    remind(() => generator.next());

    function remind(resume) {
      let next;
      try {
        next = resume();
      } catch (error) {
        reject(error);
        return;
      }
      if (next.done) {
        resolve(next.value)
        return;
      }
      //console.log(next);
      const promise = Promise.resolve(next.value);
      promise.then(
        function fulfillmentReaction(result) {
          remind(() => generator.next(result))
        },
        function rejectionReaction(error) {
          remind(() => generator.throw(error))
        });
    }
  });

}

/*
 fetch(weatherUrl)
 .then(function(response) {
 return response.json();
 })
 .then(function(weather) {
 console.log(weather);
 });
 */