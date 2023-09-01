# https://leetcode.com/problems/nth-highest-salary/
import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    employee = employee.drop_duplicates(subset=['salary'])
    n = len(employee.index)
    employee = employee.sort_values(by=['salary'])
    res = [employee.iloc[n - N]['salary'].tolist()] if n >= N else [[None]]
    return pd.DataFrame(res, columns=["getNthHighestSalary(" + str(N) + ")"])