def get_digits(number):
    thousands = number // 1000
    hundreds = (number % 1000) // 100
    tens = (number % 100) // 10
    ones = number % 10

    return [thousands, hundreds, tens, ones]

def are_all_digits_identical(digits):
    return len(set(digits)) == 1

def sort_digits_descending(digits):
    return sorted(digits, reverse=True)

def sort_digits_ascending(digits):
    return sorted(digits)

def form_number(digits):
    return digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3]

def perform_kaprekar_routine(number):
    count = 0

    while number != 6174:
        digits = get_digits(number)

        if are_all_digits_identical(digits):
            return f"All digits are identical. Kaprekar's routine will not converge."

        desc_number = form_number(sort_digits_descending(digits))
        asc_number = form_number(sort_digits_ascending(digits))

        number = desc_number - asc_number

        count += 1
        print(f"Iteration {count}: {desc_number} - {asc_number} = {number}")

    return f"Got the Kaprekar's number 6174 after {count} iterations"

def kaprekar_routine_with_input():
    number = int(input("Enter a four-digit number: "))
    result = perform_kaprekar_routine(number)
    print(result)

kaprekar_routine_with_input()
