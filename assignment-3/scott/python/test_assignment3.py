import unittest
from .Assignment3 import secondFunc, firstFunc, modFirstFunc

class TestExceptions(unittest.TestCase):

    def test_second_func_raises(self):
        with self.assertRaisesRegex(Exception, "Test error in secondFunc"):
            secondFunc()

    def test_first_func_context(self):
        try:
            firstFunc()
        except Exception as e:
            self.assertEqual(str(e), "Test error in firstFunc")
            # In Python 3, __context__ is set automatically when an exception is raised 
            # while handling another.
            self.assertIsNotNone(e.__context__)
            self.assertEqual(str(e.__context__), "Test error in secondFunc")
            # __cause__ should be None because we didn't use 'from'
            self.assertIsNone(e.__cause__)

    def test_mod_first_func_cause(self):
        try:
            modFirstFunc()
        except Exception as e:
            self.assertEqual(str(e), "Test error in modFirstFunc")
            # __cause__ is set explicitly using 'from'
            self.assertIsNotNone(e.__cause__)
            self.assertEqual(str(e.__cause__), "Test error in secondFunc")
            # __context__ is also set
            self.assertEqual(str(e.__context__), "Test error in secondFunc")

if __name__ == '__main__':
    unittest.main()
