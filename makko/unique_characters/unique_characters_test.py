import unittest

from .unique_characters import unique_characters_no_aditional_structures, \
    unique_characters_aditional_structures


class UniqueCharacterTest(unittest.TestCase):

    def test_single_character(self):
        self.assertEqual(True, unique_characters_no_aditional_structures('A'))

    def test_different_capitalization_is_different(self):
        self.assertEqual(
            True,
            unique_characters_no_aditional_structures('AaeEiIoOuU')
        )

    def test_characters_repeated(self):
        self.assertEqual(
            False,
            unique_characters_no_aditional_structures('fghjklwfe')
        )

    def test_blank_space_is_considered_a_character(self):
        self.assertEqual(
            False,
            unique_characters_no_aditional_structures('asd fgh jkl')
        )

    def test_unique_characters_in_string(self):
        self.assertEqual(
            True,
            unique_characters_no_aditional_structures('asdf')
        )

    def test_single_character_aditional_structures(self):
        self.assertEqual(True, unique_characters_aditional_structures('A'))

    def test_different_capitalization_is_different_aditional_structures(self):
        self.assertEqual(
            True,
            unique_characters_aditional_structures('AaeEiIoOuU')
        )

    def test_characters_repeated_aditional_structures(self):
        self.assertEqual(
            False,
            unique_characters_aditional_structures('fghjklwfe')
        )

    def test_blank_space_is_considered_a_character_aditional_structures(self):
        self.assertEqual(
            False,
            unique_characters_aditional_structures('asd fgh jkl')
        )

    def test_unique_characters_aditional_structures_in_string(self):
        self.assertEqual(
            True,
            unique_characters_aditional_structures('asdf')
        )


if __name__ == '__main__':
    unittest.main()
