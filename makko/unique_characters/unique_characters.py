def unique_characters_no_aditional_structures(string_to_check):
    string_length = len(string_to_check)
    index = 0
    while index < string_length:
        character = string_to_check[index]
        character_count = 1
        second_index = index + 1
        while second_index < string_length:
            if character == string_to_check[second_index]:
                character_count += 1
                if character_count > 1:
                    print('Nay: ', character, 'was found more than once')
                    return False
            second_index += 1
        index += 1
    print('Yay, the string has unique characters')
    return True


def unique_characters_aditional_structures(string_to_check):
    letters_checked = []
    for character in string_to_check:
        if character in letters_checked:
            print('Nay, the character', character, 'was found more than once')
            return False
        else:
            letters_checked.append(character)
    print('Yay, the string has unique characters')
    return True
