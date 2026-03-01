import traceback

def secondFunc():
    raise Exception("Test error in secondFunc")

def firstFunc():
    try:
        secondFunc()
    except Exception:
        raise Exception("Test error in firstFunc")
    
def modFirstFunc():
    try:
        secondFunc()
    except Exception as e:
        raise Exception("Test error in modFirstFunc") from e

def main():
    print('--- Starting firstFunc error handling ---')
    try:
        firstFunc()
    except Exception as e:
        print(f"Error: {e}")
        print(f"Cause: {e.__cause__}")
        print(f"Context: {e.__context__}")
        print("Stack Trace:")
        traceback.print_exc()
    print('--- End of firstFunc error handling ---\n')

    print('--- Starting modFirstFunc error handling ---')
    try:
        modFirstFunc()
    except Exception as e:
        print(f"Error: {e}")
        print(f"Cause: {e.__cause__}")
        print(f"Context: {e.__context__}")
        print("Stack Trace:")
        traceback.print_exc()
    print('--- End of modFirstFunc error handling ---')

if __name__ == "__main__":
    main()