import unittest

from .add_remove_replace import is_one_edit_away


class OneEditAwayTest(unittest.TestCase):

    def valid_cases(self):
        self.assertEqual(True, is_one_edit_away("", ""))
        self.assertEqual(True, is_one_edit_away("aa", "aa"))
        self.assertEqual(True, is_one_edit_away("", "a"))
        self.assertEqual(True, is_one_edit_away("a", ""))
        self.assertEqual(True, is_one_edit_away("a", "b"))
        self.assertEqual(True, is_one_edit_away("q", "qq"))
        self.assertEqual(True, is_one_edit_away("qq", "q"))

    def invalid_cases(self):
        self.assertEqual(False, is_one_edit_away("ba", ""))
        self.assertEqual(False, is_one_edit_away("word", "dwor"))
        self.assertEqual(False, is_one_edit_away("ab", "ba"))
        self.assertEqual(False, is_one_edit_away("a", "aaa"))
        self.assertEqual(False, is_one_edit_away("qwer", "qrew"))


if __name__ == '__main__':
    print(is_one_edit_away("", ""))
    print(is_one_edit_away("aa", "aa"))
    print(is_one_edit_away("", "a"))
    print(is_one_edit_away("a", ""))
    print(is_one_edit_away("a", "b"))
    print(is_one_edit_away("q", "qq"))
    print(is_one_edit_away("qq", "q"))
    print(is_one_edit_away("ba", ""))
    print(is_one_edit_away("word", "dwor"))
    print(is_one_edit_away("ab", "ba"))
    print(is_one_edit_away("a", "aaa"))
    print(is_one_edit_away("qwer", "qrew"))

    unittest.main()
