import unittest

from .unique_characters import unique_characters


class UniqueCharacterTest(unittest.TestCase):

    def test_single_character(self):
        self.assertEqual(True, unique_characters('A'))

    def test_different_capitalization_is_different(self):
        self.assertEqual(True, unique_characters('AaeEiIoOuU'))

    def test_characters_repeated(self):
        self.assertEqual(False, unique_characters('fghjklwfe'))

    def test_blank_space_is_considered_a_character(self):
        self.assertEqual(False, unique_characters('asd fgh jkl'))

    def test_unique_characters_in_string(self):
        self.assertEqual(True, unique_characters('asdf'))


if __name__ == '__main__':
    unittest.main()
