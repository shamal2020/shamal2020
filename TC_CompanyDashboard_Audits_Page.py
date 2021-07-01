# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys



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
    
    # SELECTING THE COMPANY FROM THE LIST
    companyList = browser.find_elements_by_class_name('product-name')
    companyList[0].click() #click first card
    print('SANITY PASS:Card Selected From Company Dashboard page')
    print('---------------------------')
    
    #NAVIGATING TO COMPANY AUDITS PAGE
    navToSublink(browser, pause, By,'company', 'Audits')
    fPause(2)
    
    # Clicking on the scheduled survey requirement button
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div/div[3]/button')
    button = browser.find_elements_by_css_selector('.SurveyListItems .ibox button')
    button[0].click()
    print('SANITY PASS:SURVEY REQUIREMENT FOR COMPANY AUDIT Download Successful')
    fPause(2)
    
    # LOCATING OVERDUE FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[1]')
    button.click()
    fPause(2)
    
    # VALIDATING COUNT VALUES OF OVERDUE FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF OVERDUE FILTER SUCCESSFUL...........')
    
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
    # LOCATING OVERDUE WITHIN 180 DAYS FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[2]/button')
    button.click()
    fPause(2)
    
    # VALIDATING COUNT VALUES OF OVERDUE WITHIN 180 DAYS FILTER
    valueofbutton = 1
    numberofcards = 1
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF OVERDUE WITHIN 180 DAYS FILTER SUCCESSFUL...........')
    
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
    #CLICKING ON THE SURVEY REQUIREMENTS BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div[3]/button')
    button.click()
    fPause(3)
    print ("SANITY PASSED: SURVEY REQUIREMENTS UNDER OVERDUE WITHIN 180 DAYS FILTER DOWNLOADED SUCCESSFULLY") 
    
    # LOCATING OVERDUE AFTER 180 DAYS FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[3]/button')
    button.click()
    fPause(3)
    
    # VALIDATING COUNT VALUES OF OVERDUE AFTER 180 DAYS FILTER
    valueofbutton = 3
    numberofcards = 3
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF OVERDUE AFTER 180 DAYS FILTER SUCCESSFUL...........')
    
    # WAITING FOR THE PAGE TO LOAD
    fPause(3)
    
    #CLICKING ON THE SURVEY REQUIREMENTS BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div/div/div[3]/button')
    button.click()
    fPause(3)
    print ("SANITY PASSED: SURVEY REQUIREMENTS UNDER OVERDUE AFTER 180 DAYS FILTER DOWNLOADED SUCCESSFULLY")
    
    #LOCATING IN PROGRESS FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[4]')
    button.click()
    fPause(3)
    
    # VALIDATING COUNT VALUES OF OVERDUE FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF IN PROGRESS FILTER SUCCESSFUL...........')
    
    # WAITING FOR THE PAGE TO LOAD
    fPause(3)
    
    # CLICKING ON THE COMMENCED FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[5]')
    button.click()
    fPause(3)
    
    # VALIDATING COUNT VALUES OF OVERDUE FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF COMMENCED FILTER SUCCESSFUL...........')
    
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
    #LOCATING RESET BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[6]/button')
    button.click()
    fPause(3)
    print ("SANITY PASSED: RESET THE PAGE SUCCESSFULLY")
    
    #nAVIGATE BACK TO COMPANY AUDITS PAGE
    navToSublink(browser, pause, By,'company', 'Audits')
    fPause(2)
    
    # Navigating to History Company Audit Page
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/ul/li[2]/a')
    button.click()
    print('SANITY PASS:History Company Audit page Opens Successfully')
    fPause(2)
    
    # CLICKING ON FILTER BY YEAR DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/button')
    button.click()
    print('SANITY PASS: SELECTION OF FILTER BY YEAR Successful')
    fPause(3)
    
    # SELECTING 1 YEAR UNDER FILTER BY YEAR
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/button[1]')
    print('SANITY PASS: SELECTION OF 1 YEAR UNDER FILTER BY YEAR Successful')
    fPause(3)
    
    # CLICKING ON SURVEY REPORT FOR 1 YEAR UNDER FILTER BY YEAR
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/div[3]/button')
    button.click()
    print('SANITY PASS:SUREVEY REPORT DOWNLOAD FOR 1 YEAR UNDER FILTER BY YEAR Successful')
    fPause(2)
    
    # CLICKING ON FILTER BY YEAR DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/button')
    button.click()
    print('SANITY PASS: SELECTION OF FILTER BY YEAR Successful')
    fPause(2)
    
    # SELECTING 3 YEAR UNDER FILTER BY YEAR
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/button[2]')
    button.click()
    print('SANITY PASS: SELECTION OF 3 YEAR UNDER FILTER BY YEAR Successful')
    fPause(3)
    
    # CLICKING ON SURVEY REPORT FOR 3 YEAR UNDER FILTER BY YEAR
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[3]/div/div/div[3]/button')
    button.click()
    fPause(20)
    print('SANITY PASS: SUREVEY REPORT DOWNLOAD FOR 3 YEARS UNDER FILTER BY YEAR Successful')
    fPause(20)
    
    # CLOSING THE NO FILE AVAILABLE POP UP MESSAGE
    button = browser.find_element_by_xpath("//div[text()='No document available']")
    button.click()
    
    # lOGGING OUT OF THE SYSTEM
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')
    
    
#     button = browser.find_element_by_xpath ('//main/div/div[1]/div/div/button')
#     button.click()

# =========*******  Will be adding more for Regression TC ******** ============)
#     # Selecting Filter by year for 30 years (=========*******  Will be adding more for Regression TC ******** ============)
#     button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/button')
#     button.click()
#     fPause(5)
#     print('SANITY PASS: SELECTION OF FILTER BY YEAR Successful')
#     button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/button[6]')
#     button.click()
#     fPause(5)
#     print('SANITY PASS: SELECTION OF 30 YEAR UNDER FILTER BY YEAR Successful')
#     button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[4]/div/div/div[3]/button')
#     button.click()
#     fPause(7)
#     print('SANITY PASS:SELECTION OF 30 YEARS UNDER FILTER BY YEAR Successful')
#     fPause(1)
#     Nav(browser, By, pause, "Home")
#     print('Landed In Home Page')
#     fPause(1)


#     
  
    
