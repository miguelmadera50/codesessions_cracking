
def check_true_false_cases(string1, string2):
    if string1 == string2:
        return True, True
    if abs(len(string1) - len(string2)) > 1:
        return True, False
    if len(string1) == 1 and len(string2) == 0:
        return True, True
    if len(string2) == 1 and len(string1) == 0:
        return True, True
    return False, False


def check_replacements(string1, string2):
    differences = 0
    for letter1, letter2 in zip(string1, string2):
        if letter1 != letter2:
            differences += 1
        if differences > 1:
            return False
    return True


def check_adds(string1, string2):
    if len(string1) < len(string2):
        string1, string2 = string2, string1
    # string1 is the longest
    index2 = 0
    differences = 0
    for index1 in range(len(string1)):
        letter1 = string1[index1]
        letter2 = string2[index2]
        if letter1 != letter2:
            differences += 1
            index2 -= 1
        index2 += 1
        if index2 == len(string2):
            break
    return differences < 2


def is_one_edit_away(string1, string2):
    immediate_solution, result = check_true_false_cases(string1, string2)
    if immediate_solution:
        return result
    if len(string1) == len(string2):
        result = check_replacements(string1, string2)
    else:
        result = check_adds(string1, string2)
    return result
