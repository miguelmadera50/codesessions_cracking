module.exports = function assert(result, value, description) {
  if(description) {
    console.info('\x1b[34m', `Case: "${description}"`);
  }
  if(value === result) {
    console.info('\x1b[32m', `\tAssertion success: ${value} === ${result}`);
  } else {
    console.error('\x1b[31m', `\tAssertion error: ${result} is expected to be ${value}`);
  }
}
