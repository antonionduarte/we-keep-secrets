from os import system

TEST_LIST = [
			"help",
			"register",
			"upload_base",
			"upload_pre",
			"write_base",
			"write_pre",
			"read_base",
			"read_pre",
			"grant_base",
			"grant_pre",
			"revoke_base",
			"revoke_pre",
			"userdocs",
			"topleaked",
			"topgranters"
]

NUMBER_OF_TESTS = 15

COMMAND_RUN = "java Main < ../WeKeepSecretsTests/%.2d_in_%s.txt > ../tests/%.2d_%s_test_out.txt"

for i in range(0, NUMBER_OF_TESTS):
	system(COMMAND_RUN % (i+1, TEST_LIST[i], i+1, TEST_LIST[i]))
	print(COMMAND_RUN % (i+1, TEST_LIST[i], i+1, TEST_LIST[i]))
	code = system("diff ../tests/%.2d_%s_test_out.txt ../WeKeepSecretsTests/%.2d_out_%s.txt" % (i+1, TEST_LIST[i], i+1, TEST_LIST[i]))
	if code != 0:
		print("Failed test %s!" % str(i+1))
		exit(0)