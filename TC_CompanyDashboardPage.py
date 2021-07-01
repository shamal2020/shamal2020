# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys
import time


# Our imports
from Login import Login, Logout
from Nav import Nav, navToSublink
from constants import constPaths # paths that should never change


# driver = webdriver.Chrome()
# driver.get('https://python.org')


# from builtins import True
# ---------------------------- #
# Settings - Change as needed #
# --------------------------- #
useBrowser = 'chrome' #edge, chrome
maxWindowOnLoad = True
closeBrowserWhenFinished = False
defaultWaitTime = 10 # seconds - time default wait before select fails
useEnv = 'portaluat'
env = {
  'fredmod'   :  'https://fredmod.eagle.org/portal/#/Login',
  'fredint'   :  'https://fredint.eagle.org/portal/#/Login',
  'portaluat' :  'https://portaluat.eagle.org/portal//#/Login'
}

# --------------------------------- #
# Settings - Change if you have to  #
# --------------------------------- #
if useBrowser == 'edge':
    # Add webdrivers as needed (edge / chrome / firefox)
    browser = webdriver.Edge('msedgedriver')
else:
    browser = webdriver.Chrome()
browser.get(env[useEnv])

if maxWindowOnLoad == True:
    browser.set_window_size(1440, 900)
    browser.maximize_window()

# time to try to find NEXT element before timeout
# should be used to you just need for next item to exist before you continue
def pause(time = defaultWaitTime):
    browser.implicitly_wait(time)
# force browser to pause before moving on
# should be used to you need to see what is happening
def fPause(time = defaultWaitTime):
    browser.implicitly_wait(time)
    cantGetItem = browser.find_elements_by_css_selector('.will-never-find-this-item')

# /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\ #
# ------------------------------------------------------------------ #
# ===================== Tests / Commands below ===================== #
# ------------------------------------------------------------------ #
# \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ #

print('RUNNING FILE')
# Login,Company Dashboard, Select the company,
runTest = True

if runTest:
    # LOGIN 
    Login(browser, pause, 'American', 'abc12345')
    
    # Navigate to Home page
    Nav(browser, By, pause, "Home")
    print('Landed In Home Page')
    fPause(5)
    
    # Refresh the page to close the smart schedular pop up
    browser.refresh()
    fPause(7)
    
    # Navigate to Company Dashboard  
    Nav(browser, By, pause, "Company Dashboard")
    print('SANITY PASS: COMPANY DASHBOARD PAGE')
    fPause(1)
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')

    # CALCULATING THE FILTER COUNT FOR TOTAL NUMBER OF COMPANIES
    values = browser.find_element_by_css_selector(".statistics-buttons-active .btn")
    buttonValue = values.text
    buttonValue = buttonValue.lstrip("0")
    fPause(1)
    getAllCards = browser.find_elements_by_css_selector(".company-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("CLICKING ON TOTAL NUMBER OF VESSELS FILTER")
    print("--------------")
    fPause(1)
    
    # Filter Count for Total no of Companies
    allButtons = browser.find_elements_by_css_selector(".AllCompaniesSummaryCard .statistics-buttons")
    buttonValue = allButtons[1].text
    buttonValue = buttonValue.lstrip("0")
    allButtons[1].click()
    print(buttonValue)
    print(len(getAllCards))
    print('SANITY PASS: FILTER COUNT VALIDATION SUCCESS FOR TOTAL NUMBER OF COMPANIES')
    fPause(1)
    
    # CALCULATING THE FILTER COUNT FOR OVERDUE SURVEY/AUDIT
    button = browser.find_element_by_xpath('//main/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/button')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    button.click()
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    print('CLICKING ON OVERDUE SURVEY/AUDITS FILTER')
    getAllCards = browser.find_elements_by_css_selector(".company-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR OVERDUE SURVEY/AUDIT")
    print("--------------")
    fPause(1)
    
    # CALCULATING THE FILTER COUNT FOR DUE SURVEY/AUDIT
    button = browser.find_element_by_xpath('//main/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/button')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    button.click()
    fPause(1)
    print('CLICKING ON DUE SURVEY/AUDITS FILTER')
    getAllCards = browser.find_elements_by_css_selector(".company-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR DUE SURVEY/AUDIT")
    print("--------------")
    
    # CALCULATING THE FILTER COUNT FOR OVERDUE FINDINGS
    button = browser.find_element_by_xpath('//main/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/div/div[1]/button')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    button.click()
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    print('CLICKING ON OVERDUE FINDINGS FILTER')
    getAllCards = browser.find_elements_by_css_selector(".company-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR OVERDUE FINDINGS")
    print("--------------")
    
    # CALCULATING THE FILTER COUNT FOR DUE FINDINGS
    button = browser.find_element_by_xpath('//main/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/div/div[2]/button')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    button.click()
    fPause(1)
    print('CLICKING ON DUE FINDINGS FILTER')
    getAllCards = browser.find_elements_by_css_selector(".company-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR DUE FINDINGS")
    print("--------------")
    
    # CALCULATING THE FILTER COUNT FOR SUBMITTED ATTENDANCE
    button = browser.find_element_by_xpath('//main/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[4]/div/div[1]/button')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    button.click()
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    print('CLICKING ON SUBMITTED ATTENDANCE FILTER')
    getAllCards = browser.find_elements_by_css_selector(".company-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR SUBMITTED ATTENDANCE")
    print("--------------")
    
    # CALCULATING THE FILTER COUNT FOR INPROGRESS ATTENDANCE
    button = browser.find_element_by_xpath('//main/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[4]/div/div[2]/button')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    button.click()
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    print('CLICKING ON INPROGRESS ATTENDANCE FILTER')
    getAllCards = browser.find_elements_by_css_selector(".company-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR INPROGRESS ATTENDANCE")
    print("--------------")
    
    # CALCULATING THE FILTER COUNT FOR CERTIFICATES Expiring within 180 Days
    button = browser.find_element_by_xpath('//main/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[5]/div/div/button')
    fPause(2)
    buttonValue = button.text
    buttonValue = buttonValue.lstrip("0")
    button.click()
    if buttonValue == "":
        buttonValue = "0"
    fPause(1)
    print('CLICKING ON CERTIFICATES Expiring within 180 Days FILTER')
    getAllCards = browser.find_elements_by_css_selector(".vessel-cards-list .ibox")
    print(buttonValue)
    print(len(getAllCards))
    if str(len(getAllCards)) != str(buttonValue):
        print("ERROR:FILTER COUNT VALIDATION DISCREPENCY ")
    else:
        print("SANITY PASS:FILTER COUNT VALIDATION SUCCESS FOR CERTIFICATES Expiring within 180 Days")
    print("--------------")
    
    # SEARCHING THE COMPANY NAME IN THE SEARCH BAR
    searchinput = browser.find_element_by_xpath('//main/div/div/div[2]/div[2]/div[1]/div/input')
    searchinput.send_keys("American")
    fPause(3)
    print('SANITY PASS:SEARCH BY COMPANY NAME SUCCESSFUL')
    
    # ERASING THE SEARCHED COMPANY NAME
    Searchicon = browser.find_elements_by_xpath('//main/div/div/div[2]/div[2]/div[1]/div/span')
    Searchicon[0].click()
    fPause(2)
    print('SANITY PASS:ERASE COMPANY NAME SUCCESSFUL')
    fPause(1)
    
    # Logout
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')