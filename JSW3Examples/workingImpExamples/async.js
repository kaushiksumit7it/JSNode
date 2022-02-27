let getData = (name) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => { // Database 
             name = 'alka';
            if (name) {
                resolve(name);
            }
            if (!name) {
                reject(null);
            }
        }, 200);

    });
}

async function example() {
    let name;
    try {
        name = await getData();

    } catch (err) {
        name = err;
    }
    console.log(name);

}

example();