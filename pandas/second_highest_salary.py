# https://leetcode.com/problems/second-highest-salary/
import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    lst = employee['salary'].drop_duplicates().tolist()
    mx, smx = 0, None
    for x in lst:
        if mx == 0:
            mx = x
        elif x > mx:
            smx = mx
            mx = x
        elif smx == None:
            smx = x
        elif x > smx and x <= mx:
            smx = x

    return pd.DataFrame([[smx]], columns=['SecondHighestSalary'])