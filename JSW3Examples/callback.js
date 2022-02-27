function cb(num) {
    setTimeout(() => {
        num * 10;
    }, 200);
    console.log(num);

};

function example(num, cb) {
    cb(num);
    console.log('hello');
};

example(10, cb);