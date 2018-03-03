const assert = require('../helpers/assert');

function isUniqueCharacterString(string) {
  const characterMap = {};

  for (const character of string) {
    if(characterMap[character]) {
      return false
    } else {
      characterMap[character] = true;
    }
  }
  return true;
}

function isUniqueCharacterStringNoDataStructure(string) {
  for (let index = 0; index < string.length; index++) {
    for (let secondaryIndex = index + 1; secondaryIndex < string.length; secondaryIndex++) {
      if (string[index] === string[secondaryIndex]) {
        return false
      }
    }
  }

  return true;
}

const caseOne = 'uniqe';
const caseTwo = 'nonunique';
const caseThree = 'hello';
const caseFour = 'asa';

assert(isUniqueCharacterString(caseOne), true, caseOne);
assert(isUniqueCharacterString(caseTwo), false, caseTwo);
assert(isUniqueCharacterString(caseThree), false, caseThree);
assert(isUniqueCharacterString(caseFour), false, caseThree);

assert(isUniqueCharacterStringNoDataStructure(caseOne), true, caseOne);
assert(isUniqueCharacterStringNoDataStructure(caseTwo), false, caseTwo);
assert(isUniqueCharacterStringNoDataStructure(caseThree), false, caseThree);
assert(isUniqueCharacterStringNoDataStructure(caseFour), false, caseFour);

