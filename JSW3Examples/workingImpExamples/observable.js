const { Observable, from, of } = require('rxjs');

// Convert string to observable
// The observable will emit the sequence of characters in the string
const observableFromString = from('Hello RxJS!');
observableFromString.subscribe((character) => console.log(character), err =>  {});
