let getData = (name) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => { // Database 
            name = 'alka';
            resolve(name);
            if (!name) {
                reject(null);
            }
        }, 200);

    })
}

async function example() {
    const name = await getData();
    console.log(name);

}
example();