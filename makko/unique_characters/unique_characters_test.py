import unittest

from .unique_characters import unique_characters_no_aditional_structures, \
    unique_characters_aditional_structures


class UniqueCharacterTest(unittest.TestCase):

    def test_single_character(self):
        self.assertEqual(True, unique_characters_no_aditional_structures('a'))

    def test_unique_chars(self):
        self.assertEqual(
            True,
            unique_characters_no_aditional_structures('abc')
        )

    def test_unique_chars_2(self):
        self.assertEqual(
            True,
            unique_characters_no_aditional_structures('qwertyuiopasdfghjklzxcvbnm')
        )

    def test_false_unique_chars(self):
        self.assertEqual(
            False,
            unique_characters_no_aditional_structures('aa')
        )

    def test_false_unique_chars_2(self):
        self.assertEqual(
            False,
            unique_characters_no_aditional_structures('qwertyuiopasdfghjklzxcvbnq')
        )

    def test_false_unique_chars_3(self):
        self.assertEqual(
            False,
            unique_characters_no_aditional_structures('qwertyuiopasdfghjklzxcvbnzuythe')
        )

    def test_false_unique_chars_4(self):
        self.assertEqual(
            False,
            unique_characters_no_aditional_structures('qwertyhnbgfdsabzxc')
        )

    #//////////////////////
    def test_single_character(self):
        self.assertEqual(True, unique_characters_aditional_structures('a'))

    def test_unique_chars(self):
        self.assertEqual(
            True,
            unique_characters_aditional_structures('abc')
        )

    def test_unique_chars_2(self):
        self.assertEqual(
            True,
            unique_characters_aditional_structures('qwertyuiopasdfghjklzxcvbnm')
        )

    def test_false_unique_chars(self):
        self.assertEqual(
            False,
            unique_characters_aditional_structures('aa')
        )

    def test_false_unique_chars_2(self):
        self.assertEqual(
            False,
            unique_characters_aditional_structures('qwertyuiopasdfghjklzxcvbnq')
        )

    def test_false_unique_chars_3(self):
        self.assertEqual(
            False,
            unique_characters_aditional_structures('qwertyuiopasdfghjklzxcvbnzuythe')
        )

    def test_false_unique_chars_4(self):
        self.assertEqual(
            False,
            unique_characters_aditional_structures('qwertyhnbgfdsabzxc')
        )


if __name__ == '__main__':
    unittest.main()
